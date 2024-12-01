package org.example;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Query wikiSearch = new Query();
        wikiSearch.getQuery();

        ServerResponse wikiResponse = new ServerResponse();
        wikiResponse.serverRequest(wikiSearch);

        wikiResponse.parsing();
        wikiResponse.showResult();

        Article article = new Article();
        article.openArticle(wikiResponse.searchResult.length(), wikiResponse.searchResult);
    }

}