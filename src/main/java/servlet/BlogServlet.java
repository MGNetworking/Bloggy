package servlet;

import com.sun.corba.se.impl.oa.toa.TOA;
import entities.User;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/blog")
public class BlogServlet extends HttpServlet {

    private static final long serialVersionUID = -274469182366198628L;

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        String articleNumber = req.getParameter("article");

        // selection d'un article
        if (articleNumber != null) {

            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/webArticle/dellPrecision7520.jsp")
                    .forward(req, resp);
        }

        // renvoi sur la page des article de blog
        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/blog.jsp")
                .forward(req, resp);
    }

}
