package service;

import dao.DaoArticle;
import entities.ArticleBlog;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.rmi.transport.ObjectTable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Slf4j
public class ServiceArticle {

    private DataSource dataSource;
    private DaoArticle daoArticle;

    private void initDataSource() throws RuntimeException {

        try {
            if (dataSource == null) {

                Context initContext = new InitialContext();
                Context contextEnv = (Context) initContext.lookup("java:comp/env");
                this.dataSource = (DataSource) contextEnv.lookup("Myblog");

                daoArticle = new DaoArticle(this.dataSource);
            }

        } catch (NamingException ne) {

            String message = "Naming Exception data Source : " +
                    ne.getStackTrace() + "\n" +
                    ne.getMessage() + "\n" +
                    ne.getCause();

            log.error(message);
            throw new RuntimeException(message);
        }
    }

    public boolean createArticle(HttpServletRequest request)
            throws IOException,
            ServletException,
            SQLException {

        this.initDataSource();
        boolean execute = false;

        try {

            execute = this.daoArticle.create(request);

        } catch (SQLException sql) {

            String message = "Echec to create: " +
                    sql.getStackTrace() + "\n" +
                    sql.getMessage() + "\n" +
                    sql.getCause();

            log.error(message);
            throw new RuntimeException(message);
        }

        return execute;
    }

    public boolean updateArticle(HttpServletRequest request) throws RuntimeException {

        this.initDataSource();
        boolean execute = false;

        try {

            execute = this.daoArticle.update(request);

        } catch (SQLException sql) {

            String message = "Echec to update : " +
                    sql.getStackTrace() + "\n" +
                    sql.getMessage() + "\n" +
                    sql.getCause();

            log.error(message);
            throw new RuntimeException(message);
        }

        return execute;
    }

    public boolean deleteArticle(HttpServletRequest request) throws RuntimeException {

        this.initDataSource();
        boolean execute = false;

        try {
            execute = this.daoArticle.delete(request);
        } catch (SQLException sql) {

            String message = "Echec to delete article : " +
                    sql.getStackTrace() + "\n" +
                    sql.getMessage() + "\n" +
                    sql.getCause();

            log.error(message);
            throw new RuntimeException(message);
        }

        return execute;
    }

    /**
     * Allows to get list of article
     * @param request
     * @return
     * @throws RuntimeException
     */
    public List<ArticleBlog> findAllArticle(HttpServletRequest request) throws RuntimeException {

        this.initDataSource();
        List<ArticleBlog> listArticle = null;

        try {
            listArticle = this.daoArticle.findAll();
        } catch (SQLException sql) {

            String message = "Echec to get find All article : " +
                    sql.getStackTrace() + "\n" +
                    sql.getMessage() + "\n" +
                    sql.getCause();

            log.error(message);
            throw new RuntimeException(message);
        }

        return listArticle;
    }


}
