import org.eclipse.jetty.server.{Server, ServerConnector}
import org.eclipse.jetty.servlet.ServletContextHandler
import org.glassfish.jersey.servlet.ServletContainer
import org.slf4j.LoggerFactory

/**
  * Created by dossluca on 28/02/2017.
  */
object JettyServer extends App {

  val logger = LoggerFactory.getLogger(this.getClass)

  val context = new ServletContextHandler(ServletContextHandler.SESSIONS)
  context.setContextPath("/")

  val server = new Server()

  val connector = new ServerConnector(server)
  connector.setPort(8081)
  connector.setHost("192.168.42.1")

  server.addConnector(connector)

  server.setHandler(context)

  val servlet = context.addServlet(classOf[ServletContainer], "/*")
  servlet.setInitOrder(0)

  // Tells the Jersey Servlet which REST service/class to load.
  servlet.setInitParameter(
    "jersey.config.server.provider.classnames",
    classOf[OntologyServer].getCanonicalName())

  //servlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true")

  try {
    server.start();
    server.join();
  }
  catch {
    case e: Exception => logger.error("Jetty exception:", e)
    case i: InterruptedException => logger.error("Jetty exception:", i)
  }
  finally {
    server.destroy();
  }
}
