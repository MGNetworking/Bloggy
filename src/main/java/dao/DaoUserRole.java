package dao;

import entities.RoleUser;
import entities.User;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to manage user roles
 */
@Slf4j
public class DaoUserRole {
    private DataSource dataSource;

    private static String DELETE_ROLE = "DELETE FROM blog.user_role where id_user= ? and role_name=?";
    private static String INSERT_ROLE = "INSERT INTO blog.user_role (id_user, role_name)values(?,?)";

    public DaoUserRole(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Allows to delete a user Role.
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean delete(User user, RoleUser roleUser) throws SQLException {

        boolean operttion = false;

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement prst = connection.prepareStatement(DELETE_ROLE)) {

            prst.setLong(1, user.getId());
            prst.setString(2, roleUser.toString());


            // operation test
            if (prst.executeUpdate() == 0) {
                operttion = true;
            }


        } catch (SQLException sqle) {

            String message = "problem on the delete operation" +
                    sqle.getMessage() + " | " +
                    sqle.getSQLState();

            log.error(message);

            throw new RuntimeException(message);

        } catch (Exception e) {

            String message = "A technical error has occurred" +
                    e.getMessage() + " | " +
                    e.getStackTrace();

            log.error(message);
            throw new RuntimeException(message);
        }


        return operttion;
    }

    /**
     * allows you to add a role to a user
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean create(User user, RoleUser roleUser) throws SQLException {

        boolean operttion = false;

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement prst = connection.prepareStatement(INSERT_ROLE)) {

            prst.setLong(1, user.getId());
            prst.setString(2, roleUser.toString());

            if (prst.executeUpdate() == 0) {
                operttion = true;
            }


        } catch (SQLException sqle) {

            String message = "problem on the insert operation" +
                    sqle.getMessage() + " | " +
                    sqle.getSQLState();

            log.error(message);

            throw new RuntimeException(message);

        } catch (Exception e) {

            String message = "A technical error has occurred" +
                    e.getMessage() + " | " +
                    e.getStackTrace();

            log.error(message);
            throw new RuntimeException(message);
        }

        return operttion;
    }

}
