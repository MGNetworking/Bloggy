package servlet;

import dao.DaoRole;
import dao.DaoUser;
import entities.RoleUser;
import entities.User;
import lombok.extern.slf4j.Slf4j;

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
    private DaoRole daoRole;

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

            if (daoRole == null){
                daoRole = new DaoRole(dataSource);
            }

        } catch (NamingException nex) {

            log.warn("Error : " + nex.getCause() + " | " + nex.getRootCause());
            throw new ServletException(nex);
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo acces a la page de gestion des droit admin
        // todo fait un find user sur tout les user de la base

        log.info("Gestion des droit admin do get");

        try {
            List<User> listUser = daoUser.findAll();

            log.info("List des utilisateur "+ "\n" +
                    listUser);

            if (listUser != null){

                req.setAttribute("ListUser", listUser);
                this.getServletContext().getRequestDispatcher("/WEB-INF/gestion/gestionAdmin.jsp")
                        .forward(req,resp);

            }

        } catch (SQLException e) {

            // todo faire traitement
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // todo apres verification des droits de modification des droit fait par le filtre scrf
        // todo insert ou update des droits du ouo des user selectionné

        String tb =  req.getParameter("tb");

        log.info(tb);

        try{

            Map<Long , RoleUser> mapRole = daoRole.findAll();



        }catch (SQLException sql){

            log.error(sql.getMessage());

        }catch (Exception e){

            log.error(e.getMessage());
        }

    }
}
