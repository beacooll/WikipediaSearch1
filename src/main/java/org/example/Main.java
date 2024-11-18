package org.example;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Query wiki_search = new Query();
        wiki_search.getQuery();

        ServerResponse wiki_response = new ServerResponse();
        wiki_response.serverRequest(wiki_search);
        wiki_response.showResult();


        System.out.println("Выбирите номер статьи");

        }
    }

}