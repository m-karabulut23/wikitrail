import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class APICaller{
    public static String getArticleInfo(String name){
        try {
            String token = "eyJraWQiOiJzeVNnS1JaZWdwcDFlSGZEYnlsR2YrTnBjVmVXUDZJNGJlSFpOWjBDZVdrPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJlNGM4NTQyOC0yMGQxLTcwYWMtMTkwMS02MjVhMGZlMDc5Y2EiLCJjb2duaXRvOmdyb3VwcyI6WyJncm91cF8xIl0sImlzcyI6Imh0dHBzOi8vY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb20vdXMtZWFzdC0xX0tiNW5ZZDN6dSIsImNsaWVudF9pZCI6IjY0MXU0aTdncHR1ZmZzc2w0bTlvYXR2NHU5Iiwib3JpZ2luX2p0aSI6IjkxMGRkYzgyLTViZDAtNDc0OS05ZmJjLWU2YjNhN2M4ZGJmYiIsImV2ZW50X2lkIjoiM2YxZmM1NDktNmUxZS00Y2MyLWFhNzctZjA3NTdiZmI3ZTBmIiwidG9rZW5fdXNlIjoiYWNjZXNzIiwic2NvcGUiOiJhd3MuY29nbml0by5zaWduaW4udXNlci5hZG1pbiIsImF1dGhfdGltZSI6MTc5MzgyMTQ5MywiZXhwIjoxNzkzOTA3ODkzLCJpYXQiOjE3OTM4MjE0OTMsImp0aSI6ImEwMGE4MDkyLTZkZTktNDhkMi1hZjMwLTRiOGI4NjdlMjVlYSIsInVzZXJuYW1lIjoibWthcmFidWx1dDIzIn0.KUUGiaC2A0v9VmgkUqo4poovhSoo-Oxpdz7l5xeZRMaJbQ5Z7F_uMuMKYDLoxVjLJUjODAcp5Svl9Y3WOkczpaXniVM3LJSbcQEITSbWnphUT_PNJVaRIfofhc5Z7Dr3xER8MP9oioGBGE8i3P9JUt8cwETvE62xuTqYh7RqFYBhGDmMGdRA9VF9oK7-WFd-rJFyroVajI64o35idv-15KvrbAF-YARmcQIjQOTtUDX2Bzj-FTRVKOeXNikgsmiDmojiWxuvWxyD1M4Mozo66ZAIrrDmA6ISU-QPCasLuctxo2fF9gI3POQjs2HsF44MQQ9-Em14r-GFp5XObrK4VQ";
            String articleName = name;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.enterprise.wikimedia.com/v2/articles/"
                            + articleName + "?limit=3"))
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() == 200) {
                return response.body();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}