package servlet;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private Logger LOGGER = LoggerFactory.getLogger(HomeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("HOME page vers index.jsp");

        LOGGER.debug("debug : WEB-INF/index.jsp");
        LOGGER.trace("trace : WEB-INF/index.jsp");

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);

    }



}
