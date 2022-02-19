package com.revature.pokedex;

import com.revature.pokedex.repository.DexRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class SQLDexRepository implements DexRepository {

    @Override
    public Mtg getCard(String name) {
        Mtg result = null;
        //Connection conn = DriverManager.getConnection();
        return null;
    }

    @Override
    public List<Mtg> getCards() {
        return null;
    }
}
