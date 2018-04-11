package blog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Created by tangmengzheng on 2017/1/11.
 */
public class SessionFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        Long user = ( Long ) hrequest.getSession().getAttribute("userId");//判断用户是否登录

        if (user == null) {
            String path = hrequest.getRequestURI();
            if(!path.startsWith("/login") &&  !path.startsWith("/logout") && !path.startsWith("/register") && !path.startsWith("/public")) {
                wrapper.sendRedirect("/login");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    public void destroy() {

    }
}
