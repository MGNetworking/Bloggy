package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/galerie")
public class GalerieServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String identifiant = req.getParameter("id");

        if ( identifiant != null){

            System.out.println("param : " + identifiant );
            if (identifiant.equals("nancy") || identifiant.equals("paris")) {

                System.out.println("envoir vers " + identifiant);
                req.getRequestDispatcher("/WEB-INF/jsp/webGaleries/galerieImage.jsp")
                        .forward(req, resp);
            }
        }





        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/galeries.jsp")
                .forward(req, resp);

    }


}
