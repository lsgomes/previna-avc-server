package server;

/**
 * Created by Lucas on 15/04/2017.
 */
public class UtilsJava {
    static String extractNameFromURI(String uri) {
        String[] splitted = uri.split("#");
        return splitted[1];
    }
}
