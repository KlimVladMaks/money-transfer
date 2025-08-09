package me.klimvlad.moneytransfer.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ApiClient {
    private static final String BASE_URL = "http://localhost:8080/api/users";

    public String registerUser(String login, String password, String description) throws IOException, InterruptedException {
        // Кодируем параметры для URL
        String encodedLogin = URLEncoder.encode(login, StandardCharsets.UTF_8);
        String encodedPassword = URLEncoder.encode(password, StandardCharsets.UTF_8);
        String encodedDescription = URLEncoder.encode(description, StandardCharsets.UTF_8);
        
        String url = String.format("%s/register?login=%s&password=%s&description=%s", 
                BASE_URL, encodedLogin, encodedPassword, encodedDescription);
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        return response.body();
    }
}
