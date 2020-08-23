package servlet;

import entities.User;
import dao.DaoUser;
import lombok.extern.slf4j.Slf4j;
import util.TokenHelper;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@WebServlet(urlPatterns = "/connection")
public class ConnectionServlet extends HttpServlet {

    /*    @Resource(name = "Myblog")*/
    private DataSource dataSource;
    private DaoUser daoUser;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 2 Day in seconds
    private static final int TIME_TOKEN_AUTH = 2 * 24 * 60 * 60;

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
     * Refert to the connection form
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException,
            IOException {

        String connection = req.getParameter("connection");

        if (connection != null) {

            req.setAttribute("formulaire", "connection");
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/webFormulaire/formulaire.jsp")
                    .forward(req, resp);

        } else {

            resp.sendRedirect(req.getContextPath() + "/home");
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
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException,
            IOException {
        User user = (User) req.getSession().getAttribute("user");

        // authentification test
        try {

            user.setName(req.getParameter("name"));
            user.setPassword(req.getParameter("password"));
            user = this.daoUser.authentication(user);

        } catch (RuntimeException re) {

            log.info("Echec de la tentative de connection " + re.getMessage());

            user.addAttemp(false);

            if (user.getAttemp() == 3){

                // initialise le delais d'attente
                if (user.getWaitingConnection() == null){
                    user.addWaitingConnection();

                    log.info("delais de d'attente : " + user.getWaitingConnectionFormater());
                }

                resp.sendRedirect(req.getContextPath() + "/home");

            }else{

                // referral to the authentication page
                req.setAttribute("formulaire", "connection");
                this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/webFormulaire/formulaire.jsp")
                        .forward(req, resp);

            }

        }


        // Create user to session
        if (user.getId() != null) {

            req.getSession().setAttribute("user", user);

            log.info("Remember me : " + req.getParameter("remember"));

            if (req.getParameter("remember") != null) {

                // add token user
                user.setToken(TokenHelper.generateToken(60));
                user.setTokenDate(Timestamp
                        .valueOf(LocalDateTime
                                .now()
                                .plusSeconds(TIME_TOKEN_AUTH)
                        )
                );


                if (this.daoUser.update(user) == true) {

                    Cookie cookieAuthentification = new Cookie("token_auth", user.getToken());
                    cookieAuthentification.setHttpOnly(true);
                    cookieAuthentification.setMaxAge(TIME_TOKEN_AUTH);
                    resp.addCookie(cookieAuthentification);

                } else {
                    user.deleteTokenUser();
                }

            }

            // renvoi vers la page de retour de connection
            req.setAttribute("retourUser" , "connection");
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/webFormulaire/interaction.jsp")
                    .forward(req, resp);

        }


    }


}
