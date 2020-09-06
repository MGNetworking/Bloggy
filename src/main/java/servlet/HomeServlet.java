package servlet;

import entities.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        if (user != null){
            log.info("home info user : " + user.toString());
        }else {
            log.info("home info user : null");
        }
        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/principale/index.jsp")
                .forward(req,resp);

    }

}
