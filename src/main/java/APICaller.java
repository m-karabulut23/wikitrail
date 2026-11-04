import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class APICaller {

    private static final HttpClient client =
            HttpClient.newHttpClient();

    private static final String BASE_URL =
            "https://en.wikipedia.org/w/rest.php/v1/";

    public static String getArticleInfo(String name) {
        try {
            String articleName = URLEncoder.encode(
                    name.replace(" ", "_"),
                    StandardCharsets.UTF_8
            ).replace("+", "%20");

            String url = BASE_URL + "page/"
                    + articleName + "/with_html";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent",
                            "WikiTrail/1.0 (student project)")
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() == 200) {
                return response.body();
            }

            System.out.println("API Error: "
                    + response.statusCode());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}