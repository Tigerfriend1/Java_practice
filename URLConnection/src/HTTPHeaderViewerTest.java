import java.util.Map;
import java.util.Scanner;

public class HTTPHeaderViewerTest {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            String urlString = scanner.nextLine();
            Map<String, String> headers = HTTPHeaderViewer.getHeaders(urlString);
            if(headers!=null)
                System.out.println(headers.get("Content-Type"));
        }
    }
}
