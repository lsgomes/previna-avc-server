package server; /**
 * Created by Lucas on 15/04/2017.
 */

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class JettyServerJava {

    public static void main(String[] args) throws Exception {

        Logger logger = LoggerFactory.getLogger(JettyServerJava.class);
        //"%s=%s%n",
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            logger.info(envName + " = "+ env.get(envName));
        }

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);

        String port = System.getenv("PORT");

        if (port == null) {
            port = System.getenv("HTTP_PLATFORM_PORT");

            if (port == null) {
                port = System.getenv("%HTTP_PLATFORM_PORT%");
                if (port == null) {
                    port = "8081";
                }
            }
        }

        logger.info("Setting port to " + port);

        connector.setPort(Integer.parseInt(port));


        //connector.setHost("192.168.25.49")

        server.addConnector(connector);

        server.setHandler(context);

        ServletHolder servlet = context.addServlet(ServletContainer.class, "/*");
        servlet.setInitOrder(0);
        //ObjectMapper
        // Tells the Jersey Servlet which REST service/class to load.
        servlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                OntologyServerJava.class.getCanonicalName());

        servlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        try {
            server.start();
            server.join();
        }
        catch (Exception e) {
           logger.error("Jetty exception:", e);
        }
        finally {
            server.destroy();
        }
    }
}
