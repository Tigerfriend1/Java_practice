package edu.pnu.cse;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class HttpClientTest {
    public static void main(String[] args) {
        Optional<MyIp> Ip = MyIpAPI.getIp();
        Ip.ifPresent(System.out::println);
        //Ip.ifPresent(ip -> System.out.println(MyIpAPI.gson.toJson(ip)));
    }

    private class MyIpAPI{
        private static final String url = "https://httpbin.org/ip";
        private static final Gson gson = new Gson();
        private static final HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        public static Optional<MyIp> getIp(){
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type","application/json")
                    .build();
            Optional<MyIp> myIp = Optional.empty();
            try {
                HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                if(response.statusCode()==200){
                    myIp = Optional.ofNullable(gson.fromJson(response.body(),MyIp.class));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return myIp;

        }

    }

    private class MyIp{
        private String origin;

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getOrigin() {
            return origin;
        }

        @Override
        public String toString() {
            return String.format("{\n" +
                    "  \"origin\": \"%s\"\n" +
                    "}",origin);
        }
    }

}

