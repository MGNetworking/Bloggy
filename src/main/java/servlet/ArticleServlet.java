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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // liste des pages pouvant faire des article
    Map<String , String> pageListe;

    @Override
    public void init() throws ServletException {

        pageListe = new HashMap<>(10);
        pageListe.put("indexArticle", "/WEB-INF/jsp/webArticle/indexArticle.jsp");
        pageListe.put("blogArticle","/WEB-INF/jsp/webArticle/blogArticle.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        String pageArticle = req.getParameter("page");

        // si est contenu dans la liste
        if (pageArticle != null ){

            System.out.println("Value of Key : " + pageListe.get(pageArticle));
            // renvoie vers la page de creation d'un article
            this.getServletContext()
                    .getRequestDispatcher(pageListe.get(pageArticle))
                    .forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

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
