public class Main {

    public static void main(String[] args) {

        Article article = new Article("Albert_Einstein");

        System.out.println("Name: " + article.getName());
        System.out.println("URL: " + article.getUrl());

        System.out.println("\nArticle Body:");
        System.out.println(article.getBody());

        System.out.println("\nHyperlinks:");

        for (String link : article.getLinks()) {
            System.out.println(link);
        }

        System.out.println("\nTotal Links: "
                + article.getLinks().size());
    }
}