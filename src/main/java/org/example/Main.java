package org.example;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Query wiki_search = new Query();
        wiki_search.getQuery();

        ServerResponse wiki_response = new ServerResponse();
        wiki_response.serverRequest(wiki_search);

        wiki_response.parsing();
        wiki_response.showResult();

        Article article = new Article();
        article.openArticle(wiki_response.searchResult.length(), wiki_response.searchResult);
    }

}