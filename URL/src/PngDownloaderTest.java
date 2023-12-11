import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PngDownloaderTest {
    public static void main(String[] args) {
        Path path = PngDownloader.get("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
        try {
            System.out.println(Files.size(path));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}