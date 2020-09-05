package dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * this interface allows to create generically access methods to database
 *
 * @param <T>
 */
public interface IDAO<T> {

    abstract boolean create(HttpServletRequest request) throws SQLException, Exception;

    abstract boolean update(HttpServletRequest request) throws SQLException, Exception;

    abstract boolean delete(HttpServletRequest request) throws SQLException, Exception;

    abstract T find(String request) throws SQLException;

    abstract List<T> findAll() throws SQLException;
}
