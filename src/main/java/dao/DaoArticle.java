package dao;

import entities.ArticleBlog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DaoArticle implements IDAO {

    private DataSource dataSource;
    private final static Logger LOGGER = LogManager.getLogger(DaoArticle.class);

    /**
     * Chemin dans lequel les images seront sauvegardées.
     */


    private static String INSERT_ARTICLE =
            "insert into blog.article (id_user, date, page, titre, article, pathimage, commentimage)VALUES(?,?,?,?,?,?,?)";

    private static String SELECT_ARTICLE =
            "SELECT id_article, date, page, titre, article, pathimage, commentimage " +
                    "FROM blog.article where id_article = ?";

    private static String SELECT_ALL = "SELECT id_article, date, page, titre, article, pathimage, commentimage " +
            "FROM blog.article";

    private static String UPDATE_ARTICLE = "UPDATE blog.article " +
            "SET date = ?,page = ?, titre = ?,article = ?,pathimage = ?,commentimage = ? where id_article = ?";

    private static String DELETE_ARTILCE = "DELETE FROM blog.article where id_article = ?";

    private static String SELECT_OFFSET = "SELECT id_article, date, page, titre, article, pathimage, commentimage " +
            "FROM blog.article order by id_article limit ? offset ?";

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

        Connection connection = connection = dataSource.getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        INSERT_ARTICLE,
                        Statement.RETURN_GENERATED_KEYS)
        ) {

            connection.setAutoCommit(false);                    // gestion de la transaction
            ArticleBlog articleBlog = new ArticleBlog();

            System.out.println("local date time  : " + LocalDateTime.now());
            System.out.println("local date time to valof Time stamps : " + Timestamp.valueOf(LocalDateTime.now()));
            System.out.println("ID : " +Long.parseLong(request.getParameter("id")));

            articleBlog.setId(Long.parseLong(request.getParameter("id")));
            preparedStatement.setLong(1, articleBlog.getId());

            // add to values article and data
            articleBlog.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setTimestamp(2, articleBlog.getTimestamp());

            articleBlog.setPage(request.getParameter("page"));
            preparedStatement.setString(3, articleBlog.getPage());

            articleBlog.setTitle(request.getParameter("titre"));
            preparedStatement.setString(4, articleBlog.getTitle());

            articleBlog.setArticle(request.getParameter("article"));
            preparedStatement.setString(5, articleBlog.getArticle());

            // add image to server
            DaoFile.createFile(request, articleBlog);

            preparedStatement.setString(6, articleBlog.getPathImage());

            articleBlog.setCommentImage(request.getParameter("image-commentaire"));
            preparedStatement.setString(7, articleBlog.getCommentImage());


            // excution de la requete
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
            System.out.println(message);
            connection.rollback();


        }catch (IOException ioe) {

            String message = "erreur ioe : " +
                    ioe.getStackTrace() + "\n" +
                    ioe.getMessage() + "\n" +
                    ioe.getCause();

            LOGGER.error(message);
            System.out.println(message);
            connection.rollback();

        } catch (ServletException se) {

            String message = "erreur Servlet Exception : " +
                    se.getStackTrace() + "\n" +
                    se.getMessage() + "\n" +
                    se.getCause();

            LOGGER.error(message);
            System.out.println(message);
            connection.rollback();

        } finally {

            if (connection != null) {

                connection.close();
                System.out.println("Fermeture de la connection a la base de données");
            }
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
            preparedStatement.setString(4, articleBlog.getTitle());
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
                    articleBlog.setTitle(resultSet.getString(4));
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
                    articleBlog.setTitle(resultSet.getString(4));
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
     * Methode permet la gestion d'une pagination. La pagination demande le nombre d'article limite
     * ainsi que le décalage de la liste.
     * <p>
     * Exemple : la liste des 10 premier article => limite = 10 , offset = 0;
     *
     * @param request
     * @param limite
     * @param offset
     * @return
     */
    public List<ArticleBlog> findPaginate(HttpServletRequest request, int limite, int offset)
            throws SQLException {

        List<ArticleBlog> listArticle = new ArrayList<>(limite);

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_OFFSET)) {

            preparedStatement.setInt(1, limite);
            preparedStatement.setInt(2, offset);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    ArticleBlog articleBlog = new ArticleBlog();

                    articleBlog.setId(resultSet.getLong(1));
                    articleBlog.setTimestamp(resultSet.getTimestamp(2));
                    articleBlog.setPage(resultSet.getString(3));
                    articleBlog.setTitle(resultSet.getString(4));
                    articleBlog.setArticle(resultSet.getString(5));
                    articleBlog.setPathImage(resultSet.getString(6));
                    articleBlog.setCommentImage(resultSet.getString(7));

                    listArticle.add(articleBlog);


                }

            }


        }
        return listArticle;
    }

}
