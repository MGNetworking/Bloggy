package servlet;

import dao.DaoRole;
import dao.DaoUser;
import dao.DaoUserRole;
import entities.RoleUser;
import entities.User;
import lombok.extern.slf4j.Slf4j;
import util.TraitementFormulaire;

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
import java.util.List;
import java.util.Map;

@Slf4j
@WebServlet(urlPatterns = "/gestionAdmin")
public class GestionAdminServlet extends HttpServlet {

    private DataSource dataSource;
    private DaoUser daoUser;
    private DaoUserRole daoUserRole;

    private List<User> listUser;

    @Override
    public void init() throws ServletException {
        try {

            if (dataSource == null) {

                Context initContext = new InitialContext();
                Context contextEnv = (Context) initContext.lookup("java:comp/env");

                this.dataSource = (DataSource) contextEnv.lookup("Myblog");

            }

            if (daoUser == null) {
                daoUser = new DaoUser(dataSource);
            }

            if (daoUserRole == null) {
                daoUserRole = new DaoUserRole(dataSource);
            }

        } catch (NamingException nex) {

            log.warn("Error : " + nex.getCause() + " | " + nex.getRootCause());
            throw new ServletException(nex);
        }
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("Gestion des droit admin do get");

        String identiter = req.getParameter("identiter");

        // modify identity
        if (identiter != null ) {

            if(identiter.equals("formulaire")){

                req.setAttribute("formulaire", "inscription");
                req.setAttribute("identiter", "new");

                this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/webFormulaire/formulaire.jsp")
                        .forward(req, resp);
            }

        } else {


            try {

                if ((listUser = daoUser.findAll()) != null) {

                    req.setAttribute("ListUser", listUser);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/gestion/gestionAdmin.jsp")
                            .forward(req, resp);

                }

            } catch (SQLException sql) {

                log.error("Une erreur est survenu : " + sql.getMessage());

                req.setAttribute("error", "400");
                this.getServletContext().getRequestDispatcher("/WEB-INF/return/error.jsp")
                        .forward(req, resp);

            } catch (Exception e) {

                log.error("Une erreur est survenu : " + e.getMessage());

                req.setAttribute("error", "500");
                this.getServletContext().getRequestDispatcher("/WEB-INF/return/error.jsp")
                        .forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newForm = req.getParameter("newForm");

        if (newForm != null) {

            if(newForm.equals("newId")){

            // tranforme request in user object
            User user = TraitementFormulaire.formulaireInscription(req);
            boolean modify = false;



            if (user != null) {

                // add id user for update
                user.setId(((User) req.getSession().
                        getAttribute("user")).
                        getId());

                modify = daoUser.update(user);          // update new identity
            }

            if (modify == true) {

                user = daoUser.authentication(user);   // Get user right white new identity
                req.getSession().setAttribute("user", user);
            }


            req.setAttribute("retour", "newIdentity");
            req.setAttribute("validation", modify);
            this.getServletContext().getRequestDispatcher("/WEB-INF/return/returnMessage.jsp")
                    .forward(req, resp);
            }

        } else {

            try {

                TraitementFormulaire.formulaireGestionDroit(req, listUser, daoUserRole);

                req.setAttribute("retour", "droit");
                req.setAttribute("validation", true);
                this.getServletContext().getRequestDispatcher("/WEB-INF/return/returnMessage.jsp")
                        .forward(req, resp);

            } catch (SQLException sql) {

                log.error(sql.getMessage());

                req.setAttribute("retour", "droit");
                req.setAttribute("validation", false);
                this.getServletContext().getRequestDispatcher("/WEB-INF/return/returnMessage.jsp")
                        .forward(req, resp);

            } catch (Exception e) {

                log.error(e.getMessage());

                req.setAttribute("error", "500");
                this.getServletContext().getRequestDispatcher("/WEB-INF/return/error.jsp")
                        .forward(req, resp);
            }
        }
    }
}
