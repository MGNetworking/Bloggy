package dao;

import entities.RoleUser;
import entities.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Slf4j
public class DaoUser {

    private DataSource dataSource;
    private static String FIELD_USER = "id_user, name ,firstname ,avatar , email";

    private static String SQL_GET_AUTHENTICATION = "SELECT " + FIELD_USER +
            " FROM blog.user where name = ? AND password_user = ?";

    private static String SQL_GET_DROIT =
            "SELECT role_name FROM blog.user_role where id_user = ?";

    private static String SQL_UPDATE =
            "UPDATE blog.user SET name = ? , " +
                    "firstname = ? , " +
                    "avatar = ? , " +
                    "password_user = ? , " +
                    "email = ? ," +
                    "token = ? ," +
                    "tokendate = ? where id_user = ?";

    private static String SQL_SEARCH_TOKEN = "SELECT name,password_user FROM blog.user where token = ?";

    public DaoUser(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Methode permet l'authentification d'un user.
     *
     * @param dataSource
     * @return User object
     */
    public User authentication(User user) {


        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statementAuth = connection.prepareStatement(SQL_GET_AUTHENTICATION);
             PreparedStatement statementDroit = connection.prepareStatement(SQL_GET_DROIT)) {

            log.info("user dao :" + user.toString());

            // recherche du user
            statementAuth.setString(1, user.getName());
            statementAuth.setString(2, user.getPassword());

            // Si il existe on mappe les valeurs du user
            try (ResultSet resultSetAut = statementAuth.executeQuery()) {

                if (resultSetAut.next()) {

                    user.setId(resultSetAut.getLong(1));
                    user.setFirstName(resultSetAut.getString(3));
                    user.setAvatar(resultSetAut.getString(4));
                    user.setEmail(resultSetAut.getString(5));

                } else {

                    log.info("user not found for : " + user.toString());
                }
            }

            // mapping des droit du user
            if (user.getId() != null) {

                // recherche des droits du user par son ID
                statementDroit.setInt(1, (int) (long) user.getId());

                try (ResultSet resultSetDroit = statementDroit.executeQuery()) {

                    while (resultSetDroit.next()) {

                        String name = resultSetDroit.
                                getString("role_name");

                        user.getListeRole().
                                put(name , new RoleUser(name));

                    }
                    log.info("User get : " + user.toString());
                }
            }

        } catch (SQLException e) {

            log.error("Enter refuser " +
                    e.getMessage() + " | " +
                    e.getSQLState());

        } catch (Exception e) {
            log.error("Execption " +
                    e.getMessage() + " | " +
                    e.getStackTrace());
        }

        return user;
    }

    public boolean create(User user) throws SQLException {
        return false;
    }


    public boolean update(User user) {

        boolean execute = false;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statementToken = connection.prepareStatement(SQL_UPDATE)) {

            log.info("User upade : " + user);

            statementToken.setString(1, user.getName());
            statementToken.setString(2, user.getFirstName());
            statementToken.setString(3, user.getAvatar());
            statementToken.setString(4, user.getPassword());
            statementToken.setString(5, user.getEmail());
            statementToken.setString(6, user.getToken());
            statementToken.setTimestamp(7, user.getTokenDate());

            statementToken.setLong(8, user.getId());

            int resultat = statementToken.executeUpdate();

            if (resultat == 0) {
                throw new SQLException();
            }

            execute = true;
        } catch (SQLException e) {

            log.error("Token not create : " +
                    e.getMessage() + " | " +
                    e.getSQLState());

        }

        return execute;
    }


    public boolean delete(User user) throws SQLException {
        return false;
    }

    /**
     * Allows to get a user by his token , if user is find in databases
     * so a searching in databases is execute for searching his user right
     *
     * @param cookie
     * @return
     * @throws SQLException
     */
    public User findUserByToken(Cookie cookie) throws SQLException {

        User user = new User();

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SEARCH_TOKEN)) {

            statement.setString(1, cookie.getValue());

            log.info("get user by token ");

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    user.setName(resultSet.getString(1));
                    user.setPassword(resultSet.getString(2));

                }
            }

            // search to user right
            if (user != null) {
                user = this.authentication(user);
            }

            log.info("User get by token : " + user.toString());

        } catch (SQLException e) {

            String message = "Error query : " +
                    e.getMessage() + " | " +
                    e.getSQLState();
            log.error(message);

            throw new SQLException(message);
        } catch (Exception e) {

            String message = "Error to excution softwar : " +
                    e.getMessage() + " | " +
                    e.getStackTrace();
            log.error(message);
        }

        return user;
    }


    public List findAll() throws SQLException {
        return null;
    }
}
