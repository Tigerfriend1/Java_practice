import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class PngDownloader {
    public static Path get(String url) {
        try {
            URL imageUrl = new URL(url);
            String fileName = url.substring(url.lastIndexOf('/') + 1);
            Path outputPath = Files.createTempFile(fileName, ".png");

            try (BufferedInputStream in = new BufferedInputStream(imageUrl.openStream());
                 FileOutputStream out = new FileOutputStream(outputPath.toFile())) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            return outputPath;
        } catch (IOException ex) {
            System.err.println("Error in downloading image: " + ex.getMessage());
            return null;
        }
    }
}
