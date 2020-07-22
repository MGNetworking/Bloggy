package service;

import dao.DaoArticle;
import entities.ArticleBlog;
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

public class ServiceArticle {

    private DataSource dataSource;
    private DaoArticle daoArticle;
    private final static Logger LOGGER = LogManager.getLogger(ServiceArticle.class);

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

            LOGGER.error(message);
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

            LOGGER.error(sql.getMessage());
            throw new RuntimeException("Erreur sur la creation de l'article");
        }

        return execute;
    }

    public boolean updateArticle(HttpServletRequest request)
            throws RuntimeException  {

        this.initDataSource();
        boolean execute = false;

        try {
            execute = this.daoArticle.update(request);
        } catch (SQLException sql) {

            LOGGER.error(sql.getMessage());
            throw new RuntimeException("Erreur sur la mise a jour de l'article");
        }

        return execute;
    }

    public boolean deleteArticle(HttpServletRequest request)
            throws RuntimeException {

        this.initDataSource();
        boolean execute = false;

        try {
            execute = this.daoArticle.delete(request);
        } catch (SQLException sql) {

            LOGGER.error(sql.getMessage());
            throw new RuntimeException("Erreur sur la suppression de l'article");
        }

        return execute;
    }

    public List<ArticleBlog> findAllArticle(HttpServletRequest request)
            throws RuntimeException {

        this.initDataSource();
        List<ArticleBlog> listArticle = null;

        try {
            listArticle = this.daoArticle.findAll();
        } catch (SQLException sql) {

            LOGGER.error(sql.getMessage());
            throw new RuntimeException("Erreur sur la recherche de la liste des articles");
        }

        return listArticle;
    }


}
