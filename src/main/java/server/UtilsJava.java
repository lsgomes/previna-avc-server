package server;

/**
 * Created by Lucas on 15/04/2017.
 */
public class UtilsJava {
    static String extractNameFromURI(String uri) {
        if (uri.contains("#")) {
            String[] splitted = uri.split("#");
            return splitted[1];
        }
        return uri;
    }
}
