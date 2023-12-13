//HttpServer.create(new InetSocketAddress(HOSTNAME, PORT), BACKLOG) 를 이용해 서버 인스턴스를 생성합니다.
//
//server.createContext 를 이용해 서버의 컨텍스트 패스와 Handler를 설정합니다.
//컨텍스트 패스는 hello를 사용합니다.
//Handler에서는 ResponseHeaders를 설정하고 ResponseBody 를 write 합니다.
//
//write의 매개변수에는 StandardCharsets.UTF_8 로 인코딩된 byte[] 타입의 hello world를 입력합니다.

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;

public class HttpServerTest {
    public static void main(String[] args) throws IOException {
        HttpServer server=HttpServer.create(new InetSocketAddress("localhost", 9000), 0);
        server.createContext("/hello", new MyHelloHandler());
        server.setExecutor(null);
        server.start();
    }
    public static class MyHelloHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String responseBody = "hello world";
            exchange.getResponseHeaders().add("Content-Type", "text/html; UTF-8");
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,responseBody.getBytes("UTF-8").length);
            OutputStream output = exchange.getResponseBody();
            output.write(responseBody.getBytes("UTF-8"));
            output.flush();
            exchange.close();

        }
    }
}