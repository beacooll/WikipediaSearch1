package org.example;


import org.json.JSONArray;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Article {
    private int getArticleNumber(int maxArticles) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Выберите номер статьи для открытия (1-" + maxArticles + "): ");
                try {
                    int articleNumber = Integer.parseInt(reader.readLine());
                    if (articleNumber >= 1 && articleNumber <= maxArticles) {
                        return articleNumber;
                    } else {
                        System.out.println("Некорректный номер статьи. Попробуйте снова.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Пожалуйста, введите целое число. Попробуйте снова.");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода. Попробуйте снова.");
            return -1; // Return -1 to indicate an error.
        }
    }

    public void openArticle(int maxArticles, JSONArray searchResults) throws IOException {
        int numberArticle = getArticleNumber(maxArticles);
        String title = searchResults.getJSONObject(numberArticle - 1).getString("title");
        try {

            String articleUrl = ("https://ru.wikipedia.org/wiki/"+URLEncoder.encode(title, StandardCharsets.UTF_8)).replace('+', '_');
            Desktop.getDesktop().browse(URI.create(articleUrl));
        }
        catch(Exception e){
            System.err.println("Не удалось открыть статью в браузере: " + e.getMessage());
        }
    }

}
