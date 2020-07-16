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

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Resource(name = "Myblog")
    DataSource dataSource;


    @Override
    public void init() throws ServletException {
        try {

            if (dataSource == null) {
                System.out.println("blog init");

                Context initContext = new InitialContext();
                Context contextEnv = (Context) initContext.lookup("java:comp/env");

                System.out.println(contextEnv);

                System.out.println(contextEnv.lookup("Myblog"));

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setNom(req.getParameter("nom"));
        user.setPassword(req.getParameter("password"));

        System.out.println(user.toString());

        String sql = "SELECT id_user, nom, password FROM blog.user where nom = ? AND password = ?";

        try(Connection connection= this.dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1,user.getNom());
            statement.setString(2,user.getPassword());

            try(ResultSet resultSet = statement.executeQuery()){

                if (resultSet.next()){

                    user.setId(resultSet.getLong(1));
                    user.setNom(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));

                    System.out.println(user);
                    req.setAttribute("user", user);
                    req.setAttribute("data", LocalDate.now());

                    // renvoi vers la page de creation de l'article
                    this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/jsp/webArticle/articleCreation.jsp")
                            .forward(req,resp);

                }else{
                    System.out.println("user not found for :" + user.toString());
                }
            }

        }catch (SQLException sqlex){
            System.out.println(sqlex);

            throw new ServletException(sqlex);
        }

        System.out.println("doPost / blog");

    }
}
