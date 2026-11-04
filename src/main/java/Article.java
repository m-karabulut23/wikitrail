import java.util.ArrayList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Article {

    private String name;
    private String url;
    private String body;
    private ArrayList<String> links;

    public static ArrayList<String> parseArticle(String data) {
        ArrayList<String> result = new ArrayList<>();

        if (data == null || data.isEmpty()) {
            return result;
        }

        // Parse JSON response
        JsonObject article = JsonParser.parseString(data)
                .getAsJsonObject();

        // Extract article information
        String name = article.get("title").getAsString();
        String key = article.get("key").getAsString();
        String html = article.get("html").getAsString();

        // Construct Wikipedia URL
        String url = "https://en.wikipedia.org/wiki/" + key;

        // Parse HTML with the article URL as its base
        Document document = Jsoup.parse(html, url);

        // Extract plain text
        String body = document.body().text();

        // Store article information
        result.add(name);
        result.add(url);
        result.add(body);

        // Extract Wikipedia hyperlinks
        for (Element link : document.select("a[href]")) {

            String fullURL = link.absUrl("href");

            try {
                java.net.URI linkURI = java.net.URI.create(fullURL);

                // Only include internal Wikipedia article links
                if (!"en.wikipedia.org".equals(linkURI.getHost())) {
                    continue;
                }

                String path = linkURI.getRawPath();

                if (path == null || !path.startsWith("/wiki/")) {
                    continue;
                }

                String articlePath = path.substring(6);

                // Exclude special namespaces
                if (articlePath.contains(":")) {
                    continue;
                }

                // Remove section fragments
                String cleanURL = "https://en.wikipedia.org" + path;

                // Avoid duplicate links
                if (!result.contains(cleanURL)
                        && !cleanURL.equals(url)) {
                    result.add(cleanURL);
                }

            } catch (IllegalArgumentException e) {
                // Ignore invalid hyperlinks
            }
        }

        return result;
    }

    public Article(String article) {
        this.links = new ArrayList<>();

        if (article == null || article.isBlank()) {
            throw new IllegalArgumentException(
                    "Article name cannot be empty."
            );
        }

        // Retrieve article through REST API
        String data = APICaller.getArticleInfo(article);

        if (data == null) {
            throw new IllegalStateException(
                    "Failed to retrieve article: " + article
            );
        }

        // Parse response
        ArrayList<String> information = parseArticle(data);

        if (information.size() < 3) {
            throw new IllegalStateException(
                    "Failed to parse article: " + article
            );
        }

        // Initialize fields
        this.name = information.get(0);
        this.url = information.get(1);
        this.body = information.get(2);

        // Store hyperlinks
        for (int i = 3; i < information.size(); i++) {
            this.links.add(information.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getBody() {
        return body;
    }

    public ArrayList<String> getLinks() {
        return links;
    }
}