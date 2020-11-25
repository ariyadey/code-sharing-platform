package platform.controller;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//todo play with this class
//@WebFilter("/api/*")
@Component("/api/*")
public final class APIResponseHeaderFilter implements Filter {

    @Override
    public final void doFilter(ServletRequest request,
                               ServletResponse response,
                               FilterChain chain) throws IOException, ServletException {
        final var httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Content-Type", "application/json");
        chain.doFilter(request, response);
    }

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {}
//
//    @Override
//    public void destroy() {}
}
