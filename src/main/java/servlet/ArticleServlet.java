package servlet;

import entities.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB seuil de la taille du fichier
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 5 * 5 // 25 MB
)
@WebServlet(urlPatterns = "/article")
public class ArticleServlet extends HttpServlet {

    private static final long serialVersionUID = 1273074928096412095L;

    /*
     * Chemin dans lequel les images seront sauvegardées.
     */
    public static final String IMAGES_FOLDER = "/static/image/article";

    public String uploadPath;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getAttribute("user");

        if (user != null) {

            // renvoie vers la page de creation d'un article
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/webArticle/articleCreation.jsp")
                    .forward(req, resp);

        } else {

            // TODO rajouter un message dans la page pour signaler l'echec

            // renvoie vers la page de création d'article
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/webArticle/connectionAdmin.jsp")
                    .forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getAttribute("user");

        uploadPath = getServletContext().getRealPath( IMAGES_FOLDER );
        File uploadDir = new File( uploadPath );
        if ( ! uploadDir.exists() ) uploadDir.mkdir();

        for ( Part part : req.getParts() ) {

            System.out.println(part.getName());

            String fileName = getFileName( part );
            System.out.println("filName : "+fileName);

            String fullPath = uploadPath + File.separator + fileName;
            System.out.println("fullPath : "+fullPath);

            part.write( fullPath );
        }

    }

    /*
     * Récupération du nom du fichier dans la requête.
     */
    private String getFileName( Part part ) {
        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( content.trim().startsWith( "filename" ) ){
                System.out.println("file name methode ");
                return content.substring( content.indexOf( "=" ) + 2, content.length() - 1 );
            }

        }
        return "Default.file";
    }
}
