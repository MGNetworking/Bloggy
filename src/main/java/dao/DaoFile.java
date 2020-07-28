package dao;

import entities.ArticleBlog;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@Slf4j
public class DaoFile  {

    public static final String IMAGES_FOLDER = "static\\image\\article\\";

    public static void createFile(HttpServletRequest request,
                                  ArticleBlog articleBlog)
            throws IOException, ServletException {


            Collection<Part> parts = request.getParts();
            parts.forEach(part -> {

                if (part.getName().equals("image-article")) {

                    try {

                        articleBlog.setPathImage(IMAGES_FOLDER + getFileName(part));

                        part.write(request.getServletContext().getRealPath("") +
                                articleBlog.getPathImage());

                    } catch (IOException ioe) {

                        String message = "Error to write file " +
                                ioe.getMessage() + "\n" +
                                ioe.getCause() + "\n" +
                                ioe.getStackTrace() ;

                        log.error(message);
                        throw new RuntimeException(message);
                    }
                }
            });
    }


    /**
     * Allows get file name to.
     *
     * @param part Object type Part
     * @return String name to file.
     */
    private static String getFileName(Part part) {

        for (String content : part.getHeader("content-disposition").split(";")) {

            if (content.trim().startsWith("filename")) {
                log.info("filename : " + part.getName());

                return content.substring(content.indexOf("=") + 2, content.length() - 1);

            }

        }
        return "fichier.txt";
    }
}
