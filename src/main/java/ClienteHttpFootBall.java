import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttpFootBall {
    public static void main (String args[]) {
        HttpClient client = HttpClient.newHttpClient();
        /*
        HttpRequest request = HttpRequest.newBuilder()
                                 .uri(URI.create("https://api.football-data.org/v4/competitions"))
                                 .build();
         */
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.football-data.org/v4/competitions/PL/matches?matchday=28"))
                .header("X-Auth-Token", "b4236bd36e994a5ab7ea1acb256851eb")
                .build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
