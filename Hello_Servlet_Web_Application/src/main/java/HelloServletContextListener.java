import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HelloServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("HelloServletContextListener.contextInitialized");
        ServletContext ctx = sce.getServletContext();
        ApplicationContext appContext = new ApplicationContext();
        ctx.setAttribute("appContext", appContext);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) { }
    public static class ApplicationContext { }
}
