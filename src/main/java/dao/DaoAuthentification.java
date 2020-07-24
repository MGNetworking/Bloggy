package dao;

import entities.RoleUser;
import entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuthentification {

    final static Logger LOGGER = LogManager.getLogger(DaoAuthentification.class);

    /**
     * Methode permet l'authentification d'un user.
     *
     * @param dataSource
     * @return User object
     */
    public static User validation(DataSource dataSource, User user) {


        String sqlAuthentification = "SELECT id_user, nom,prenom , surnom,password_user,email" +
                " FROM blog.user where nom = ? AND password_user = ?";

        String sqlDroit = "SELECT role_name FROM blog.user_role where id_user = ?";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement statementAuth = connection.prepareStatement(sqlAuthentification);
             PreparedStatement statementDroit = connection.prepareStatement(sqlDroit)) {

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
                    System.out.println("user not found for :" + user.toString());
                    LOGGER.info("user not found for : " + user.toString());
                }
            }

            // mapping des droit du user
            if (user.getId() != null) {

                // recherche des droits du user par son ID
                statementDroit.setInt(1, (int)(long) user.getId());

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

            LOGGER.warn("Enter refuser " + e.getMessage() + " | " + e.getSQLState());
            System.out.println("Enter refuser " + e.getMessage() + " | " + e.getSQLState());
        }

        return user;
    }
}
