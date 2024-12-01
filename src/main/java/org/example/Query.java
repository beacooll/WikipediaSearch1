
package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class Query {
    URL url;
    public void getQuery(){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ввидите тему статьи");
            String query = reader.readLine();
            query = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String urlString = "https://ru.wikipedia.org/w/api.php?action=query&list=search&srsearch=" + query + "&format=json";
            this.url = new URL(urlString);
        }
        catch (IOException e) {
            System.out.println("Произошла ошибка при выполнении запроса: " + e.getMessage());
        }
    }

}
