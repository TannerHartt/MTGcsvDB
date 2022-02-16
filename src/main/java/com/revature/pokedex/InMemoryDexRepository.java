//package com.revature.pokedex;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InMemoryDexRepository {
//    private List<Mtg> cards;
//
//    public InMemoryDexRepository() {
//        cards = new ArrayList<>();
//        cards.add(Mtg.of().id(1).name("ShatterSkull Smashing").type("Sorcery"));
//    }
//
//    public String getCard(String name){
//        String result = "";
//        for (String card : this.cards){
//            if (card.contains(name)) {
//                result = card;
//            }
//        }
//        return result;
//    }
//
//    public List<String> getCards() {
//        return cards;
//    }
//
//}
