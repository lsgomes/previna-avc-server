import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.glassfish.jersey.servlet.ServletContainer

/**
  * Created by dossluca on 28/02/2017.
  */
object JettyServer extends App {

  val context = new ServletContextHandler(ServletContextHandler.SESSIONS)
  context.setContextPath("/")

  val server = new Server(8080)
  server.setHandler(context)

  val servlet = context.addServlet(classOf[ServletContainer], "/*")
  servlet.setInitOrder(0)

  // Tells the Jersey Servlet which REST service/class to load.
  servlet.setInitParameter(
    "jersey.config.server.provider.classnames",
    classOf[OntologyServer].getCanonicalName())

  servlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true")

  try {
    server.start();
    server.join();
  } finally {
    server.destroy();
  }
}
