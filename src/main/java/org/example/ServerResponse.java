package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


public class ServerResponse {
    String response;
    JSONObject jsonResponse;
    JSONArray searchResult;

    public void serverRequest(Query request) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) request.url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();
        try{
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = in.readLine();
                StringBuilder response = new StringBuilder();
                while (line != null) {
                    response.append(line);
                    line = in.readLine();
                }
                this.response = response.toString();
            }
        }
        catch (IOException e) {
            System.out.println("Произошла ошибка при выполнении запроса: " + e.getMessage());
        }
    }
    public void parsing(){
        this.jsonResponse = new JSONObject(this.response);
        this.searchResult = jsonResponse.getJSONObject("query").getJSONArray("search");
    }
    public void showResult(){
        System.out.println("Результаты поиска:");
        for (int i = 0; i < this.searchResult.length(); i++) {
            JSONObject article = this.searchResult.getJSONObject(i);
            String title = article.getString("title");
            System.out.println((i + 1) + ". " + title);
        }
    }

}
