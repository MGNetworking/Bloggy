package servlet;

import dao.DaoUser;
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

@Slf4j
@WebServlet(urlPatterns = "/inscription")
public class InscriptionServlet extends HttpServlet {

    private DataSource dataSource;
    private DaoUser daoUser;

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

        } catch (NamingException nex) {

            log.warn("Error : " + nex.getCause() + " | " + nex.getRootCause());
            throw new ServletException(nex);
        }
    }

    /**
     * Send to the registration form.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("formulaire","inscription");
        this.getServletContext().getRequestDispatcher("/WEB-INF/webFormulaire/formulaire.jsp")
                .forward(req,resp);

    }

    /**
     * Send to date base after verify.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        try{

            User user = TraitementFormulaire.formulaireInscription(req);

            if (user != null){

                // si insert ok
                if (this.daoUser.insert(user)){

                    req.setAttribute("retourUser" , "inscription");
                    req.setAttribute("user",user);
                    this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/webFormulaire/interaction.jsp")
                            .forward(req, resp);


                }


            }

            req.setAttribute("formulaire", "inscription");
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/webFormulaire/formulaire.jsp")
                    .forward(req, resp);

        }catch (RuntimeException re){

            // TODO renvoi vers la page de formulaire pour cause d'erreur sur
            // TODO le fait que le user existe deja ou autre ...
            // TODO fonction trigger a implementer


            req.setAttribute("formulaire", "inscription");
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/webFormulaire/formulaire.jsp")
                    .forward(req, resp);

        }catch (Exception e) {

            req.setAttribute("error" , "500");
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/return/error.jsp")
                    .forward(req, resp);
        }


    }
}
