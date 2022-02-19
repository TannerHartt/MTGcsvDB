package com.revature.pokedex.repository;

import com.revature.pokedex.Mtg;
import java.util.List;

public interface DexRepository {

    Mtg getCard(String name);
    List<Mtg> getCards();

}
