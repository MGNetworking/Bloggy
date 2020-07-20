package dao;

import entities.Role;
import entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import servlet.BlogServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DaoAuthentification {

    final static Logger LOGGER = LogManager.getLogger(DaoAuthentification.class);
    private User user;

    public DaoAuthentification(User user) {
        this.user = user;
    }

    /**
     * Methode permet l'authentification d'un user.
     * @param dataSource
     * @return User object
     */
    public User validation(DataSource dataSource) {


        String sqlAuthentification = "SELECT id_user, nom, password FROM blog.user where nom = ? AND password = ?";
        String sqlDroit = "SELECT role FROM blog.user_role where id_user = ?";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement statementAuth = connection.prepareStatement(sqlAuthentification);
             PreparedStatement statementDroit = connection.prepareStatement(sqlDroit)) {

            // recherche du user
            statementAuth.setString(1, this.user.getNom());
            statementAuth.setString(2, this.user.getPassword());

            // Si il existe on mappe les valeurs du user
            try (ResultSet resultSet = statementAuth.executeQuery()) {

                if (resultSet.next()) {

                    this.user.setId(resultSet.getLong(1));
/*                    this.user.setNom(resultSet.getString(2));
                    this.user.setPassword(resultSet.getString(3));*/

                } else {
                    System.out.println("user not found for :" + user.toString());
                }
            }

            // mapping des droit si user Mapper
            if (this.user.getId() != null){

                statementDroit.setLong(1, this.user.getId());

                try (ResultSet resultSet = statementDroit.executeQuery()){

                    // ajout des roles user
                    for (int i = 1 ; resultSet.next() != false ;i++){

                        this.user.getListeRole().add(new Role(resultSet.getString(i)));
                    }
                }
            }


        }catch (SQLException e) {

            // TODO ercire un log d'erreur
            System.out.println("Enter refuser "+ e.getMessage() + " | " + e.getSQLState());
        }

        return this.user;
    }
}
