package servlet;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/blog")
public class BlogServlet extends HttpServlet {

    @Resource
    DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {

            if (dataSource == null) {

                Context initContext = new InitialContext();
                Context contextEnv = (Context) initContext.lookup("java:comp/env");

                this.dataSource = (DataSource) contextEnv.lookup("Myblog");

            }
        } catch (NamingException nex) {

            System.out.println(nex);
            throw new ServletException(nex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String articleNumber = req.getParameter("article");

        if (articleNumber != null) {

            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/webArticle/dellPrecision7520.jsp")
                    .forward(req, resp);
        }


        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/blog.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doPost / blog");

    }
}
