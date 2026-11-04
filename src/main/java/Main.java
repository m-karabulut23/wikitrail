public class Main {
    public static void main(String[] args) {

        Article article = new Article("Department_of_Computer_Science_(Purdue_University)");

        System.out.println(article.getName());
        System.out.println(article.getUrl());
        System.out.println(article.getBody());
        System.out.println(article.getLinks());
    }
}
