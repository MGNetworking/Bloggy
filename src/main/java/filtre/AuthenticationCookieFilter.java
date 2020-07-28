package filtre;

import dao.DaoUser;
import entities.User;
import lombok.extern.log4j.Log4j2;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebFilter(filterName = "authentication-Cookie-Filter")
public class AuthenticationCookieFilter implements Filter {

    private static DataSource dataSource;
    private static DaoUser daoUser;

    /**
     * <p>Called by the web container
     * to indicate to a filter that it is being placed into service.</p>
     *
     * <p>The servlet container calls the init
     * method exactly once after instantiating the filter. The init
     * method must complete successfully before the filter is asked to do any
     * filtering work.</p>
     *
     * <p>The web container cannot place the filter into service if the init
     * method either</p>
     * <ol>
     * <li>Throws a ServletException
     * <li>Does not return within a time period defined by the web container
     * </ol>
     *
     * @param filterConfig a <code>FilterConfig</code> object containing the
     *                     filter's configuration and initialization parameters
     * @throws ServletException if an exception has occurred that interferes with
     *                          the filter's normal operation
     * @implSpec The default implementation takes no action.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {

            if (dataSource == null) {

                Context initContext = new InitialContext();
                Context contextEnv = (Context) initContext.lookup("java:comp/env");

                this.dataSource = (DataSource) contextEnv.lookup("Myblog");
            }

            if (daoUser == null){
                daoUser = new DaoUser(dataSource);
            }

        } catch (NamingException nex) {

            log.warn("Error : " + nex.getCause() + " | " + nex.getRootCause());
            throw new ServletException(nex);
        }

    }

    /**
     * The <code>doFilter</code> method of the Filter is called by the
     * container each time a request/response pair is passed through the
     * chain due to a client request for a resource at the end of the chain.
     * The FilterChain passed in to this method allows the Filter to pass
     * on the request and response to the next entity in the chain.
     *
     * <p>A typical implementation of this method would follow the following
     * pattern:
     * <ol>
     * <li>Examine the request
     * <li>Optionally wrap the request object with a custom implementation to
     * filter content or headers for input filtering
     * <li>Optionally wrap the response object with a custom implementation to
     * filter content or headers for output filtering
     * <li>
     * <ul>
     * <li><strong>Either</strong> invoke the next entity in the chain
     * using the FilterChain object
     * (<code>chain.doFilter()</code>),
     * <li><strong>or</strong> not pass on the request/response pair to
     * the next entity in the filter chain to
     * block the request processing
     * </ul>
     * <li>Directly set headers on the response after invocation of the
     * next entity in the filter chain.
     * </ol>
     *
     * @param request  the <code>ServletRequest</code> object contains the client's request
     * @param response the <code>ServletResponse</code> object contains the filter's response
     * @param chain    the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws IOException      if an I/O related error has occurred during the processing
     * @throws ServletException if an exception occurs that interferes with the
     *                          filter's normal operation
     * @see UnavailableException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Cookie cookieAuth = getAuthTokenCookie((HttpServletRequest) request);

        if (cookieAuth != null){    // if user have token in browser

            try{
                User user = daoUser.findUserByToken(cookieAuth);

                if(user != null){
                    ((HttpServletRequest) request).getSession().setAttribute("user", user);
                }

            }catch (SQLException sql){
                log.warn(sql.getErrorCode());

            }finally {
                chain.doFilter(request,response);
            }


        }

        chain.doFilter(request,response);


    }

    /**
     * <p>Called by the web container
     * to indicate to a filter that it is being
     * taken out of service.</p>
     *
     * <p>This method is only called once all threads within the filter's
     * doFilter method have exited or after a timeout period has passed.
     * After the web container calls this method, it will not call the
     * doFilter method again on this instance of the filter.</p>
     *
     * <p>This method gives the filter an opportunity to clean up any
     * resources that are being held (for example, memory, file handles,
     * threads) and make sure that any persistent state is synchronized
     * with the filter's current state in memory.</p>
     *
     * @implSpec The default implementation takes no action.
     */
    @Override
    public void destroy() {

    }

    /**
     * Allows get the cookie to token authentication in browser
     *
     * @param request
     * @return
     */
    private static Cookie getAuthTokenCookie(HttpServletRequest request) {
        Cookie tokenCookie = null;

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("token_auth")) {
                    tokenCookie = cookie;
                    break;
                }
            }
        }

        return tokenCookie;
    }
}
