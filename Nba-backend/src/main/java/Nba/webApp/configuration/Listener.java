package Nba.webApp.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.InputStream;
import java.util.Properties;

public class Listener implements ServletContextListener{

    /**
     * Invoked by the container when the context has been initialized.
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext ctx = servletContextEvent.getServletContext();

            final Properties props = new Properties();

            String pathToProperties = ctx.getInitParameter("properties");

            try (final InputStream inputStream = getClass().getResourceAsStream(pathToProperties)) {
                props.load(inputStream);
            }

            AppConfiguration.getInstance().setup(ctx.getContextPath(), props);
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * Invoked by the container when the context has been destroyed.
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //do nothing
    }
}
