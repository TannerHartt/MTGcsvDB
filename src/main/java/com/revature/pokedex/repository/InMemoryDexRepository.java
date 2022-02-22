package com.revature.pokedex.repository;

import com.revature.pokedex.domain.Mtg;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDexRepository implements DexRepository{
    private List<Mtg> cards;

    public InMemoryDexRepository() {
        cards = new ArrayList<>();
        cards.add(Mtg.of().manaCost(1).name("ShatterSkull Smashing").type("Sorcery"));
    }

    public List<Mtg> getCards() {
        return cards;
    }

    public Mtg getCard(String name){
        Mtg result = null;
        for (Mtg card : this.cards){
            if (card.getName().equals(name)) {
                result = card;
            }
        }
        return result;
    }
}
