package dao;

import entities.ArticleBlog;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * this interface allows to create generically access methods to database
 *
 * @param <T>
 */
public interface IDAO<Type> {

     boolean create(Type request) throws SQLException, Exception;

     boolean update(Type request) throws SQLException, Exception;

     boolean delete(Type request) throws SQLException, Exception;

     Type find(Type request) throws SQLException;

     ArticleBlog find(String id_Article) throws SQLException;

     List<ArticleBlog> findAll() throws SQLException, Exception;

}
