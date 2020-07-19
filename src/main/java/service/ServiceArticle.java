package service;

import dao.DaoArticle;
import entities.ArticleBlog;
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

public class ServiceArticle {

    private DataSource dataSource;

    private void initDataSource() throws NamingException {

        if (dataSource == null) {

            Context initContext = new InitialContext();
            Context contextEnv = (Context) initContext.lookup("java:comp/env");

            this.dataSource = (DataSource) contextEnv.lookup("Myblog");

        }
    }

    public boolean createArticle(HttpServletRequest request)
            throws IOException,
            ServletException,
            SQLException,
            NamingException {

        this.initDataSource();

        return new DaoArticle(this.dataSource).create(request);
    }


}
