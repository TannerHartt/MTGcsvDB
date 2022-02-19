package com.revature.pokedex;

import com.revature.pokedex.repository.CSVDexRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DexRepositoryTest {

    @Test
    public void getCardTest() {
        CSVDexRepository testRepo = new CSVDexRepository("mtgdatatest.csv");
        Mtg actual = testRepo.getCard("Archfiend's Vessel");
        Mtg expected = new Mtg("Archfiend's Vessel");
        Assertions.assertEquals(expected.getName(),actual.getName());


    }
}
