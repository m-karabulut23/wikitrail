import java.util.ArrayList;
import com.google.gson.JsonArray;
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

        JsonArray articles = JsonParser.parseString(data).getAsJsonArray();

        JsonObject article = null;

        for (int i = 0; i < articles.size(); i++) {
            JsonObject current = articles.get(i).getAsJsonObject();

            if (current.has("url")
                    && current.get("url").getAsString()
                    .startsWith("https://en.wikipedia.org/wiki/")) {
                article = current;
                break;
            }
        }

        if (article == null) {
            return result;
        }

        String name = article.get("name").getAsString();
        String url = article.get("url").getAsString();
        JsonObject articleBody = article.getAsJsonObject("article_body");
        String html = articleBody.get("html").getAsString();

        Document document = Jsoup.parse(html);

        String body = document.body().text();

        result.add(name);
        result.add(url);
        result.add(body);

        for (Element link : document.select("a[href]")) {
            String href = link.attr("href");

            if (href.startsWith("./")
                    && !href.contains("#")
                    && !href.contains(":")) {

                String fullURL = "https://en.wikipedia.org/wiki/"
                        + href.substring(2);

                if (!result.contains(fullURL)) {
                    result.add(fullURL);
                }
            }
        }

        return result;
    }

    public Article(String article) {
        this.links = new ArrayList<>();

        if (article == null) {
            this.name = null;
            this.url = null;
            this.body = null;
        } else {
            String data = APICaller.getArticleInfo(article);

            ArrayList<String> information = parseArticle(data);

            if (information.size() >= 3) {
                this.name = information.get(0);
                this.url = information.get(1);
                this.body = information.get(2);

                for (int i = 3; i < information.size(); i++) {
                    this.links.add(information.get(i));
                }
            }
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