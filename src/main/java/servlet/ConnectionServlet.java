package servlet;

import entities.User;
import dao.DaoAuthentification;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/connection")
public class ConnectionServlet extends HttpServlet {

    /*    @Resource(name = "Myblog")*/
    private DataSource dataSource;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Override
    public void init() throws ServletException {
        try {

            if (dataSource == null) {

                Context initContext = new InitialContext();
                Context contextEnv = (Context) initContext.lookup("java:comp/env");

                this.dataSource = (DataSource) contextEnv.lookup("Myblog");

            }
        } catch (NamingException nex) {

            // todo fair logger Error
            System.out.println(nex);
            throw new ServletException(nex);
        }

    }

    /**
     * Refert to the connection form
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String connect = req.getParameter("connect") ;

        if (connect == null){

            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/webFormulaire/connectionAdmin.jsp")
                    .forward(req, resp);

        }else if (connect.equals("deconnexion")) {

            if (req.getSession().getAttribute("user") != null){

                req.getSession().removeAttribute("user");
                // TODO supprimer le token des cookies
                // TODO le cookies doit etre dans l'objet USER
                System.out.println("connection : " + req.getParameter("connect"));

            }

            System.out.println("passe ici ");

            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/index.jsp")
                    .forward(req, resp);
        }


    }

    /**
     * Responsible for creating the user session.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User user = new User(
                req.getParameter("nom"),
                req.getParameter("password"));


        user = DaoAuthentification.validation(this.dataSource, user);

        // Create user to session
        if (user.getId() != null) {

            req.getSession().setAttribute("user", user);

            // renvoi vers la page de retour formulaire
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/webFormulaire/retourConnection.jsp")
                    .forward(req, resp);

        } else {
            // renvoir sur la page d'authentification
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/webFormulaire/connectionAdmin.jsp")
                    .forward(req, resp);

            // TODO redirection a voir ce qui est le mieux
            // resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }


    }
}
