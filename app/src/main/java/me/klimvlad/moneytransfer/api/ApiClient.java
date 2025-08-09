package me.klimvlad.moneytransfer.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private static final String BASE_URL = "http://localhost:8080/api/users";

    public String registerUser(String login, String password, String description) throws IOException, InterruptedException {
        String url = String.format("%s/register?login=%s&password=%s&description=%s", 
                BASE_URL, login, password, description);
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        return response.body();
    }
}
