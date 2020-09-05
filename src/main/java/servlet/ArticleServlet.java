package servlet;

import dao.DaoArticle;
import dto.DtoArticle;
import entities.ArticleBlog;
import entities.RoleUser;
import entities.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.NameRole;
import util.TokenHelper;

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

import static util.NameRole.USER_ARTICLE;

@Slf4j
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB seuil de la taille du fichier
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 5 * 5 // 25 MB
)
@WebServlet(urlPatterns = "/article")
public class ArticleServlet extends HttpServlet {

    private static final long serialVersionUID = 1273074928096412095L;

    private DataSource dataSource;
    private DaoArticle daoArticle;
    private int numberArticle = 0;

    @Override
    public void init() throws ServletException {

        try {
            if (dataSource == null) {

                Context initContext = new InitialContext();
                Context contextEnv = (Context) initContext.lookup("java:comp/env");
                this.dataSource = (DataSource) contextEnv.lookup("Myblog");

                if (daoArticle == null) {
                    daoArticle = new DaoArticle(this.dataSource);
                }

                numberArticle = daoArticle.countArticle();
            }


        } catch (NamingException ne) {

            String message = "Naming Exception data Source : " +
                    ne.getStackTrace() + "\n" +
                    ne.getMessage() + "\n" +
                    ne.getCause();

            log.error(message);
            throw new RuntimeException(message);

        } catch (SQLException sql) {

            log.error(sql.getMessage());
        }

    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {


        String paramPage = req.getParameter("page");
        User user = (User) req.getSession().getAttribute("user");

        boolean actionRight = false;

        // if visit the artciles
        if (paramPage.equals("visite")) {


            List<DtoArticle> listArticlePaginable = null;

            try {
                String paginable = req.getParameter("paginable");
                int page = 0;

                if (paginable != null) {
                    page = Integer.parseInt(paginable);
                    log.info("paginable parse: " + page);
                }

                page = page * 10;
                log.info("paginable : " + page);
                listArticlePaginable = daoArticle.findPaginate(req, 10, page);


                // calculating the number of pages for pagination
                int calcul = (int) Math.ceil(this.numberArticle / 10.0) - 1;

                log.info("number de page : " + calcul);
                log.info("nomber of article" +listArticlePaginable.size());

                req.setAttribute("numberOfPage", calcul);
                req.setAttribute("listArticle", listArticlePaginable);


                this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/principale/blog.jsp")
                        .forward(req, resp);

            } catch (SQLException sqle) {

                req.setAttribute("error", 500);
                this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/return/error.jsp")
                        .forward(req, resp);
            }
        } else if (user != null) {

            // for article create
            if (paramPage.equals("articleCreate")) {

                String role = ((RoleUser) user.getListeRole().get(USER_ARTICLE.getName())).getRole();

                // if has the article creation rights
                if (role.equals("USER_ARTICLE")) {

                    log.info("create article ");

                    req.setAttribute("formulaire", "Article");

                    // renvoie vers la page de creation d'un article
                    this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/webFormulaire/formulaire.jsp")
                            .forward(req, resp);

                }


            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String ActionArticle = req.getParameter("ActionArticle");
        String page = req.getParameter("page");

        // modify and delete article
        if (ActionArticle != null) {

            switch (ActionArticle) {
                case "modifier": {

                    try {


                        req.setAttribute("validation", daoArticle.update(req));
                        req.setAttribute("retour", "update");

                        this.getServletContext()
                                .getRequestDispatcher("/WEB-INF/return/returnMessage.jsp")
                                .forward(req, resp);

                    } catch (SQLException sql) {

                        log.error(sql.getMessage());

                        req.setAttribute("error", "400");
                        this.getServletContext()
                                .getRequestDispatcher("/WEB-INF/return/error.jsp")
                                .forward(req, resp);
                    }
                }
                break;
                case "supprimer": {

                    try {

                        req.setAttribute("validation", daoArticle.delete(req));
                        req.setAttribute("retour", "delete");

                        this.getServletContext()
                                .getRequestDispatcher("/WEB-INF/return/returnMessage.jsp")
                                .forward(req, resp);

                    } catch (SQLException sql) {
                        log.error(sql.getMessage());

                        req.setAttribute("error", "400");
                        this.getServletContext()
                                .getRequestDispatcher("/WEB-INF/return/error.jsp")
                                .forward(req, resp);

                    } catch (Exception e) {
                        log.error("l'article n'a pas etait ajouter : " + e.getMessage());

                        req.setAttribute("error", "400");
                        this.getServletContext()
                                .getRequestDispatcher("/WEB-INF/return/error.jsp")
                                .forward(req, resp);
                    }
                }
                break;
                case "create": {

                    // create article
                    try {

                        boolean validatArticle = daoArticle.create(req);

                        if (validatArticle == true) {
                            numberArticle++;
                        }

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
                                .getRequestDispatcher("/WEB-INF/return/error.jsp")
                                .forward(req, resp);


                    } catch (Exception e) {
                        log.error("l'article n'a pas etait ajouter : " + e.getMessage());

                        req.setAttribute("error", "400");
                        this.getServletContext()
                                .getRequestDispatcher("/WEB-INF/return/error.jsp")
                                .forward(req, resp);
                    }
                    break;
                }

                default: {
                    req.setAttribute("error", "401");
                    this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/return/error.jsp")
                            .forward(req, resp);
                }

            }


        } else if (page != null) {

            // after selection in jsp the article for delete or modify
            log.info(page.toString() + " Article");

            switch (page) {
                case "modifier": {
                    req.setAttribute("action", "modifier");
                }
                break;
                case "supprimer": {
                    req.setAttribute("action", "supprimer");
                }
                break;
            }

            try {

                // get article for affichage
                ArticleBlog articleBlog = daoArticle.find(req.getParameter("id_article"));

                // for selection form in formulaire.jsp
                req.setAttribute("formulaire", "Article");
                req.setAttribute("article", articleBlog);

                // add article in jsp or delete or modify
                this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/webFormulaire/formulaire.jsp")
                        .forward(req, resp);

            } catch (SQLException sqle) {
                log.error(sqle.getMessage());

                req.setAttribute("error", "400");
                this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/return/error.jsp")
                        .forward(req, resp);

            } catch (Exception e) {
                log.error(e.getMessage());

                req.setAttribute("error", "400");
                this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/return/error.jsp")
                        .forward(req, resp);

            }


        }
    }

}


