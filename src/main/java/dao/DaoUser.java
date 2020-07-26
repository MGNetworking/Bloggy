package dao;

import entities.RoleUser;
import entities.User;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Slf4j
public class DaoUser {

    private DataSource dataSource;

    private static String SQL_GET_AUTHENTICATION =
            "SELECT id_user, name ,firstname ,avatar , password_user ,email" +
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

    public DaoUser(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Methode permet l'authentification d'un user.
     *
     * @param dataSource
     * @return User object
     */
    public User Authentication(User user) {


        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statementAuth = connection.prepareStatement(SQL_GET_AUTHENTICATION);
             PreparedStatement statementDroit = connection.prepareStatement(SQL_GET_DROIT)) {

            // recherche du user
            statementAuth.setString(1, user.getName());
            statementAuth.setString(2, user.getPassword());

            // Si il existe on mappe les valeurs du user
            try (ResultSet resultSetAut = statementAuth.executeQuery()) {

                if (resultSetAut.next()) {

                    user.setId(resultSetAut.getLong(1));
                    user.setFirstName(resultSetAut.getString(3));
                    user.setAvatar(resultSetAut.getString(4));
                    user.setEmail(resultSetAut.getString(6));

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

                        user.getListeRole().add(
                                new RoleUser(resultSetDroit.
                                        getString("role_name")));

                    }
                    System.out.println("user : " + user.toString());
                }
            }

        } catch (SQLException e) {

            log.warn("Enter refuser " +
                    e.getMessage() + " | " +
                    e.getSQLState());
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

            statementToken.setLong(8,user.getId());

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


    public Object find(User user) throws SQLException {
        return null;
    }


    public List findAll() throws SQLException {
        return null;
    }
}
