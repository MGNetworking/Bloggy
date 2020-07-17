package servlet;

import entities.User;
import model.DaoAuthentification;

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
import java.sql.SQLException;
import java.time.LocalDate;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/webArticle/connectionAdmin.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setNom(req.getParameter("nom"));
        user.setPassword(req.getParameter("password"));

        DaoAuthentification daoValidForm = new DaoAuthentification(user);
        user = daoValidForm.validation(this.dataSource);

        // Si trouver dans la base
        if (user.getId() != null) {

            req.setAttribute("data", LocalDate.now());

            // ajout des droit a la session
            HttpSession session = req.getSession();
            session.setAttribute("droit",user.getListeRole());
            session.setAttribute("user", user);

            // renvoi vers la page de retour formulaire
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/webFormulaire/retourConnection.jsp")
                    .forward(req, resp);

        } else {
            // renvoir sur la page d'authentification
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/webArticle/connectionAdmin.jsp")
                    .forward(req, resp);

            // TODO redirection a voir ce qui est le mieux
            // resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }


    }
}
