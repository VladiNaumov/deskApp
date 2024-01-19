package fi.naumdeveloper.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonHttpClient {

    private static final String HTTP_URL ="https://your-demo.site/api/library";

    public static String HttpClient() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(HTTP_URL))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                // .connectTimeout(Duration.ofSeconds(20))
                // .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
                // .authenticator(Authenticator.getDefault())
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println("статус ответа с сервера:  " + response.statusCode());
            // System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);

        }
        return response.body();
    }
}