import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class HTTPHeaderViewer {
    public static Map<String, String> getHeaders(String urlString) {
        Map<String, String> headers = new HashMap<>();
        URL url;
        try {
            url = new URL(urlString);
            for(int i=0;;i++) {
                URLConnection connection = url.openConnection();
                String headerKey = connection.getHeaderFieldKey(i);
                String headerField = connection.getHeaderField(i);
                if(headerField==null) break;
                //System.out.println(headerKey+"="+headerField);
                headers.put(headerKey,headerField);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return headers;
    }
}
