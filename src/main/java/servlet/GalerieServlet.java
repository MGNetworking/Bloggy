package servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/galerie")
public class GalerieServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String identifiant = req.getParameter("id");

        if ( identifiant != null){

            log.info("info choix user : " + identifiant);
            if (identifiant.equals("nancy") || identifiant.equals("paris")) {

                log.info("envoir vers la page concernant : " + identifiant);
                req.getRequestDispatcher("/WEB-INF/webGaleries/galerieImage.jsp")
                        .forward(req, resp);
            }
        }

        /* retrour a la page d'entré des galeries*/
        this.getServletContext().getRequestDispatcher("/WEB-INF/principale/galeries.jsp")
                .forward(req, resp);

    }


}
