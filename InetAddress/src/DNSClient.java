import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

public class DNSClient {

    public static Optional<String> query(String urlString) {
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getByName(urlString);
            return Optional.of(inetAddress.getHostAddress());
        } catch (UnknownHostException e){
            System.out.println(urlString+" : Name or service not known.");
        }
        return Optional.empty();
    }
}
