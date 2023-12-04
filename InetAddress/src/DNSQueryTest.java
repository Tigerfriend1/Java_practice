import java.util.Optional;
import java.util.Scanner;

public class DNSQueryTest {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            String urlString = scanner.nextLine();
            Optional<String> address = DNSClient.query(urlString);
            if (address.isPresent()) System.out.println(address.get());
        }
    }
}
