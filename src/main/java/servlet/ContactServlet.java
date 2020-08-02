package servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/contact")
public class ContactServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException,
            IOException {

        req.setAttribute("formulaire","contact");
        log.info("forward => formulaire.jsp type contact");
        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/webFormulaire/formulaire.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException,
            IOException {

        log.info("doPost contact");

        req.setAttribute("retour" ,  req.getParameter("retour"));

        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/return/returnMessage.jsp")
                .forward(req,resp);
    }
}
