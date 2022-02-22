package com.revature.pokedex.repository;

import com.revature.pokedex.domain.Mtg;

import java.util.List;

public interface DexRepository {

    Mtg getCard(String name);
    List<Mtg> getCards();
   // void save(Mtg newMtg);

}
