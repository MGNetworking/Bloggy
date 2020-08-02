package servlet;

import entities.RoleUser;
import entities.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ServiceArticle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB seuil de la taille du fichier
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 5 * 5 // 25 MB
)
@WebServlet(urlPatterns = "/article")
public class ArticleServlet extends HttpServlet {

    private static final long serialVersionUID = 1273074928096412095L;

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {


        String paramPage = req.getParameter("page");
        String paramArticle =  req.getParameter("article");

        if (paramPage != null){


            if (paramPage.equals("articleCreate")) {    // Pour la creation d'article

                User user = (User) req.getSession().getAttribute("user");

                log.info("User Artilce : " + user.getListeRole());

                String role = ((RoleUser) user.getListeRole().get("USER_ARTICLE")).getRole();

                // si a les droit de creation d'article
                if (role.equals("USER_ARTICLE")) {


                    req.setAttribute("formulaire","creationArticle" );

                    // renvoie vers la page de creation d'un article
                    this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/webFormulaire/formulaire.jsp")
                            .forward(req, resp);

                }
            }


            if (paramPage.equals("visite")) {   // Pour la visiste des articles

                if (paramArticle != null){
                    if (paramArticle.equals("MyPc1")) {
                        this.getServletContext()
                                .getRequestDispatcher("/WEB-INF/webArticle/dellPrecision7520.jsp")
                                .forward(req, resp);
                    }
                }

                // Les articles de projet
                this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/principale/blog.jsp")
                        .forward(req, resp);

            }
        }




    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        try {

            boolean validatArticle = new ServiceArticle().createArticle(req);
            log.info("l'article a etait ajoute : " + validatArticle);

            req.setAttribute("validation", validatArticle);
            req.setAttribute("retour", "article");

            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/return/returnMessage.jsp")
                    .forward(req, resp);


        } catch (SQLException e) {

            log.error("l'article n'a pas etait ajouter : " + e.getSQLState());

            req.setAttribute("error", "400");

            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/return/returnMessage.jsp")
                    .forward(req, resp);


        }
    }


}
