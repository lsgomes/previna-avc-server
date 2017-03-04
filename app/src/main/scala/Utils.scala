/**
  * Created by Lucas on 04/03/2017.
  */
object Utils {
  def extractNameFromURI(uri: String): String = {
    val splitted = uri.split("#")
    splitted(1)
  }
}
