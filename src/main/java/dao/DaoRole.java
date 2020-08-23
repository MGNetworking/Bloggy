package dao;

import entities.RoleUser;
import lombok.extern.slf4j.Slf4j;

import javax.management.relation.Role;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DaoRole {

    private DataSource dataSource;

    private static String SQL_SELECT_ALL_LITSE_ROLE= "SELECT * FROM blog.user_role";

    public DaoRole(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<Long, RoleUser> findAll()throws SQLException, Exception{

        Map<Long , RoleUser> mapRole = new HashMap<>();

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_LITSE_ROLE)){

            ResultSet rst = statement.executeQuery();

            log.info("Liste des droits ... ");

            while (rst.next()){

                mapRole.put(rst.getLong("id_user"),
                        new RoleUser(rst.getString("role_name")));
            }

            log.info(mapRole.toString());


        }catch (SQLException sqle) {

            String message = "Error query : " +
                    sqle.getMessage() + " | " +
                    sqle.getSQLState();

            log.error(message);
            throw new SQLException(message);

        } catch (Exception e) {

            String message = "Error to excution softwar : " +
                    e.getMessage() + " | " +
                    e.getStackTrace();
            log.error(message);

            throw new Exception(message);

        }

        return mapRole;
    }
}
