package com.ac.kappasisland.Service;
import com.ac.kappasisland.Entities.Objet;
import com.ac.kappasisland.Repository.ObjetRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class ItemService {

    //Pointe vers l'API
    @Autowired
    private static final String API = "https://zelda.fanapis.com";
    private final HttpClient client;

    public ItemService() {
        this.client = HttpClient.newHttpClient();
    }

    public Integer getById(Long id) {
        // Retourne null car il est difficile de déterminer un id numérique dans une API dont la structure est inconnue.
        return null;
    }

    // Retourne tous les items qu'il trouve dans l'API
    public List<String> findAll() {
        List<String> items = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API + "/items"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONArray data = jsonResponse.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {
                JSONObject item = data.getJSONObject(i);
                items.add(item.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    // Retourne l'id d'un item dans l'API
    public List<String> findId() {
        List<String> ids = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API + "/items"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONArray data = jsonResponse.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {
                JSONObject item = data.getJSONObject(i);
                ids.add(item.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ids;
    }

    // Retourne le nom d'un item grâce à son id dans l'API
    public String findName(String id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API + "/items/" + id))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            return jsonResponse.getString("name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retourne la description d'un item grâce à son id dans l'API
    public String findDescription(String id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API + "/items/" + id))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            return jsonResponse.getString("description");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retourne le jeu d'un item grâce à son id dans l'API
    public String findGame(String id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API + "/items/" + id))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            return jsonResponse.getString("game");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ItemService api = new ItemService();

        System.out.println("All Items: " + api.findAll());
        System.out.println("All IDs: " + api.findId());

        // Example ID
        String exampleId = "1234";
        System.out.println("Name: " + api.findName(exampleId));
        System.out.println("Description: " + api.findDescription(exampleId));
        System.out.println("Game: " + api.findGame(exampleId));
    }

}
