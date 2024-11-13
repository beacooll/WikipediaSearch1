package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ввидите тему статьи");
        String query = reader.readLine().replace(" ", "%20");;


        String urlString = "https://ru.wikipedia.org/w/api.php?action=query&list=search&srsearch=" + query + "&format=json";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = in.readLine();
            StringBuilder response = new StringBuilder();
            while(line != null){
                response.append(line);
                line = in.readLine();
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray searchResult = jsonResponse.getJSONObject("query").getJSONArray("search");

            System.out.println(searchResult);
        }
    }

}