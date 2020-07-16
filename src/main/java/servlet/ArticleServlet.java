package servlet;

import entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/article")
public class ArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getAttribute("user");

        System.out.println(user);

        if (user != null){

            // renvoie vers la page de creation d'un article
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/webArticle/articleCreation.jsp")
                    .forward(req,resp);

        }else{

            // TODO rajouter un massage dans la page pour signaler l'echec

            // renvoie vers la page de création d'article
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/webArticle/connectionAdmin.jsp")
                    .forward(req,resp);
        }




    }
}
