package dao;

import entities.ArticleBlog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

public class DaoArticle implements IDAO {

    private DataSource dataSource;
    //private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Chemin dans lequel les images seront sauvegardées.
     */
    public static final String IMAGES_FOLDER = "static\\image\\article\\";

    private static String INSERT_ARTICLE =
            "insert into blog.article (date,page,titre,article,pathimage,commentimage)" +
                    "VALUES(?,?,?,?,?,?)";

    public DaoArticle(DataSource dataSource) {
        this.dataSource = dataSource;

        if (dataSource == null) {
            // TODO creer une connection si null
        }
    }

    /**
     * Methode pour l'ajoute en base de données d'un article.
     *
     * @param articleBlog
     * @return
     * @throws SQLException
     */
    public boolean create(HttpServletRequest request) throws SQLException {

        boolean execute = false;

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        INSERT_ARTICLE,
                        Statement.RETURN_GENERATED_KEYS)
        ) {


            connection.setAutoCommit(false);                    // gestion de la transaction

            ArticleBlog articleBlog = new ArticleBlog();

            // add to values article and data
            articleBlog.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setTimestamp(1, articleBlog.getTimestamp());

            articleBlog.setPage(request.getParameter("page"));
            preparedStatement.setString(2, articleBlog.getPage());

            articleBlog.setTitre(request.getParameter("titre"));
            preparedStatement.setString(3, articleBlog.getTitre());

            articleBlog.setArticle(request.getParameter("article"));
            preparedStatement.setString(4, articleBlog.getArticle());

            articleBlog.setCommentImage(request.getParameter("image-commentaire"));
            preparedStatement.setString(6, articleBlog.getCommentImage());

            Collection<Part> parts = request.getParts();

            parts.forEach(part -> {

                if (part.getName().equals("image-article")) {

                    // add path
                    articleBlog.setPathImage(request.getServletContext().
                            getRealPath("") +
                            IMAGES_FOLDER  +
                            getFileName(part));

                    try {
                        part.write(articleBlog.getPathImage()); // add image to folder
                    } catch (IOException ioe) {
                        System.out.println("erreur ioe" + ioe.getStackTrace() + " | " + ioe.getMessage());
                    }

                }
            });

            preparedStatement.setString(5, articleBlog.getPathImage());

            int resultatOperation = preparedStatement.executeUpdate();

            if (resultatOperation == 0) {
                throw new SQLException("Echec operation insert ");
            }


            // Get keygen to data
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

                if (resultSet.next()) {

                    int keyGen = resultSet.getInt(1);
                    articleBlog.setId((long) keyGen);
                }

            }


            connection.commit();
            connection.setAutoCommit(true);

            execute = true;

        } catch (SQLException sql) {

            // TODO logger
            System.out.println("erreur sql : " + sql.getSQLState() + "\n" +
                    sql.getStackTrace()  + "\n" +
                    sql.getMessage()  + "\n" +
                    sql.getCause());
            execute = false;

        } catch (Exception ioe) {

            // TODO logger
            System.out.println("erreur ioe" + ioe.getStackTrace() + " | " + ioe.getMessage());
            execute = false;
        }

        return execute;
    }

    @Override
    public boolean update(HttpServletRequest request) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(HttpServletRequest request) throws SQLException {
        return false;
    }

    @Override
    public Object find(HttpServletRequest request) throws SQLException {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return null;
    }

    /**
     * Methode qui récupération du nom du fichier, utilisé esclusivment pour les fichier type image.
     *
     * @param part
     * @return String le nom du fichier
     */
    private static String getFileName(Part part) {

        System.out.println("getHeaderNames() : " + part.getHeaderNames());

        for (String content : part.getHeader("content-disposition").split(";")) {

            System.out.println("Contenu : " + content);
            if (content.trim().startsWith("filename")) {

                String contente = content.substring(content.indexOf("=") + 2, content.length() - 1);
                System.out.println("content susbstring : " + content);
                return content.substring(content.indexOf("=") + 2, content.length() - 1);

            }

        }
        return "fichier.txt";
    }

}
