package com.revature.pokedex;

import com.revature.pokedex.domain.Mtg;
import com.revature.pokedex.repository.CSVDexRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DexRepositoryTest {

    @Test
    public void getCSVCardTest() {
        CSVDexRepository testRepo = new CSVDexRepository("mtgdatatest.csv");
        Mtg actual = testRepo.getCard("Archfiend's Vessel");
        Mtg expected = new Mtg("Archfiend's Vessel");
        Assertions.assertEquals(expected.getName(),actual.getName());
    }

//    @Test
//    public void getSQLCardTest() {
//        SQLDexRepository testRepo = new SQLDexRepository();
//        Mtg actual = Mtg.of().manaCost(2).name("Alpine Watchdog").type("Creature");
//        Assertions.assertEquals(actual);
//    }
}
