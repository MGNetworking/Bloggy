package servlet;

import entities.User;
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

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB seuil de la taille du fichier
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 5 * 5 // 25 MB
)
@WebServlet(urlPatterns = "/article")
public class ArticleServlet extends HttpServlet {

    private static final long serialVersionUID = 1273074928096412095L;
    private final static Logger LOGGER = LogManager.getLogger(ServiceArticle.class);
    Map<String, String> pageListe = null;

    @Override
    public void init() throws ServletException {

        pageListe = new HashMap<>(10);
        pageListe.put("indexArticle", "/WEB-INF/jsp/webArticle/indexArticle.jsp");
        pageListe.put("blogArticle", "/WEB-INF/jsp/webArticle/blogArticle.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        String pageArticle = req.getParameter("page");

        // si est contenu dans la liste
        if (pageArticle != null) {

            LOGGER.info("Value of Key : " + pageListe.get(pageArticle));
            System.out.println("Value of Key : " + pageListe.get(pageArticle));

            // renvoie vers la page de creation d'un article
            this.getServletContext()
                    .getRequestDispatcher(pageListe.get(pageArticle))
                    .forward(req, resp);

        } else {
            // redirection vers la page d'index
            resp.sendRedirect(req.getContextPath() + "/WEB-INF/jsp/index.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {


        try {

            if (req.getParameter("article").equals("createArticle")) {

                boolean validatArticle = new ServiceArticle().createArticle(req);

                req.setAttribute("validation", validatArticle);

                // TODO dans la page passer la validation
                this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/jsp/webFormulaire/retourformulaire.jsp");
            }

        } catch (SQLException e) {

            System.out.println("Une erreur SQl est survenu : " + e.getSQLState());
            LOGGER.error("Une erreur SQl est survenu : " + e.getSQLState());

        }
    }


}
