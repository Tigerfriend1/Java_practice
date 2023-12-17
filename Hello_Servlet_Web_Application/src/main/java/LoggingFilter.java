import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/hello")
public class LoggingFilter implements Filter {
    @Override public void init(FilterConfig filterConfig) { System.out.println("LoggingFilter.init");}
    @Override public void destroy() { }
    @Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        try {
            chain.doFilter(request, response);
        } finally {
            long endTime = System.currentTimeMillis();
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            String method = req.getMethod();
            String url = req.getRequestURL().toString();
            int status = res.getStatus(); String statusMessage = "OK";
            long duration = endTime - startTime;
            System.out.println(method + " " + url + " , " + duration + " ms, " + status + " (" + statusMessage + ")");
        }
    }
}