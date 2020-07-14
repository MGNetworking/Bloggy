package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/blog")
public class BlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String articleNumber = req.getParameter("article");

        if(articleNumber != null){

            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/webArticle/dellPrecision7520.jsp")
                    .forward(req,resp);
        }


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/blog.jsp")
                .forward(req, resp);
    }
}
