//package com.revature.pokedex;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.List;
//
//public class MtgAPIDexRepository implements DexRepository {
//    ObjectMapper mapper = new ObjectMapper();
//    @Override
//    public Mtg getCard(String name) {
//        Mtg result = null;
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://"))
//                .build();
//        try {
//            HttpResponse<String> response = client.send((request, HttpResponse.BodyHandlers.ofString()));
//            String httpBody = response.body();
//            Mtg newCard = mapper.readValue(httpBody, Mtg.class);
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//    @Override
//    public List<Mtg> getCards() {
//        return null;
//    }
//}
