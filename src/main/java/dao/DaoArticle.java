package dao;

import entities.ArticleBlog;
import entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DaoArticle implements IDAO {

    private DataSource dataSource;
    private final static Logger LOGGER = LogManager.getLogger(DaoArticle.class);

    /**
     * Chemin dans lequel les images seront sauvegardées.
     */
    public static final String IMAGES_FOLDER = "static\\image\\article\\";

    private static String INSERT_ARTICLE =
            "insert into blog.article (date,page,titre,article,pathimage,commentimage)VALUES(?,?,?,?,?,?)";

    private static String SELECT_ARTICLE =
            "SELECT id_article, date, page, titre, article, pathimage, commentimage " +
                    "FROM blog.article where id_article = ?";

    private static String SELECT_ALL = "SELECT id_article, date, page, titre, article, pathimage, commentimage " +
            "FROM blog.article";

    private static String UPDATE_ARTICLE = "UPDATE blog.article " +
            "SET date = ?,page = ?, titre = ?,article = ?,pathimage = ?,commentimage = ? where id_article = ?";

    private static String DELETE_ARTILCE = "DELETE FROM blog.article where id_article = ?";

    public DaoArticle(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Methode pour l'ajoute en base de données d'un article.
     * Si le requete d'insertion est en échéc,
     * aucun image ne sera ajouter sur le serveur.
     *
     * @param articleBlog
     * @return
     * @throws SQLException
     */
    public boolean create(HttpServletRequest request) throws SQLException, RuntimeException {

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

                    articleBlog.setPathImage(IMAGES_FOLDER + getFileName(part));    // add path

                    try {
                        part.write(articleBlog.getPathImage());                     // add image to folder
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

            String message = "erreur sql : " +
                    sql.getSQLState() + "\n" +
                    sql.getStackTrace() + "\n" +
                    sql.getMessage() + "\n" +
                    sql.getCause();

            LOGGER.error(message);
            throw new SQLException(message);

        } catch (Exception ioe) {

            String message = "erreur ioe" +
                    ioe.getStackTrace() + "\n" +
                    ioe.getMessage() + "\n" +
                    ioe.getCause();

            LOGGER.error(message);
            throw new RuntimeException(message);
        }

        return execute;
    }

    @Override
    public boolean update(HttpServletRequest request) throws SQLException {

        boolean execute = false;

        ArticleBlog articleBlog = (ArticleBlog) request.getAttribute("article");

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ARTICLE)) {

            // recherche de l'article par son ID
            preparedStatement.setLong(1, articleBlog.getId());
            preparedStatement.setTimestamp(2, articleBlog.getTimestamp());
            preparedStatement.setString(3, articleBlog.getPage());
            preparedStatement.setString(4, articleBlog.getTitre());
            preparedStatement.setString(5, articleBlog.getArticle());
            preparedStatement.setString(6, articleBlog.getPathImage());
            preparedStatement.setString(7, articleBlog.getCommentImage());


            preparedStatement.executeUpdate();                  // lancement de la requete

            execute = true;

        } catch (SQLException sql) {

            String Message = "Problème sql update : " +
                    sql.getCause() + "\n" +
                    sql.getSQLState() + "\n" +
                    sql.getStackTrace() + "\n" +
                    "Recherche Article par id : " + articleBlog;

            LOGGER.error(Message);
            throw new SQLException(Message);
        }

        return execute;
    }

    @Override
    public boolean delete(HttpServletRequest request) throws SQLException {

        boolean execute = false;
        ArticleBlog articleBlog = (ArticleBlog) request.getAttribute("article");

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ARTILCE)) {

            preparedStatement.setLong(1, articleBlog.getId());
            preparedStatement.executeQuery();

            execute = true;

        } catch (SQLException sql) {

            String Message = "Problème sql delete : " +
                    sql.getCause() + "\n" +
                    sql.getSQLState() + "\n" +
                    sql.getStackTrace() + "\n";

            LOGGER.error(Message);
            throw new SQLException(Message);
        }


        return execute;
    }

    /**
     * Methode qui permet de recherche d'un Article par son id
     *
     * @param request
     * @return
     * @throws SQLException
     */
    @Override
    public ArticleBlog find(HttpServletRequest request) throws SQLException {

        ArticleBlog articleBlog = new ArticleBlog();
        Long id_article = (Long) request.getAttribute("id_article");

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ARTICLE)) {

            // recherche de l'article par son ID
            preparedStatement.setLong(1, id_article);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    articleBlog.setId(resultSet.getLong(1));
                    articleBlog.setTimestamp(resultSet.getTimestamp(2));
                    articleBlog.setPage(resultSet.getString(3));
                    articleBlog.setTitre(resultSet.getString(4));
                    articleBlog.setArticle(resultSet.getString(5));
                    articleBlog.setPathImage(resultSet.getString(6));
                    articleBlog.setCommentImage(resultSet.getString(7));
                }
            }

        } catch (SQLException sql) {

            String Message = "Problème sql find : " +
                    sql.getCause() + "\n" +
                    sql.getSQLState() + "\n" +
                    sql.getStackTrace() + "\n" +
                    "Recherche Article par id : " + articleBlog;

            LOGGER.error(Message);
            throw new SQLException(Message);
        }

        return articleBlog;
    }

    @Override
    public List<ArticleBlog> findAll() throws SQLException {

        List<ArticleBlog> listArticle = new ArrayList<>();

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    ArticleBlog articleBlog = new ArticleBlog();

                    articleBlog.setId(resultSet.getLong(1));
                    articleBlog.setTimestamp(resultSet.getTimestamp(2));
                    articleBlog.setPage(resultSet.getString(3));
                    articleBlog.setTitre(resultSet.getString(4));
                    articleBlog.setArticle(resultSet.getString(5));
                    articleBlog.setPathImage(resultSet.getString(6));
                    articleBlog.setCommentImage(resultSet.getString(7));

                    listArticle.add(articleBlog);

                }

            }

        } catch (SQLException sql) {

            String Message = "Problème sql findAll : " +
                    sql.getCause() + "\n" +
                    sql.getSQLState() + "\n" +
                    sql.getStackTrace() + "\n";

            LOGGER.error(Message);
            throw new SQLException(Message);
        }

        return listArticle;
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

            } else {
                LOGGER.error("Erreur file name " + part.getName());
            }

        }
        return "fichier.txt";
    }

}
