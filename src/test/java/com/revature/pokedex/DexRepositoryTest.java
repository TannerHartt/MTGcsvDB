package com.revature.pokedex;
import com.revature.pokedex.domain.Mtg;
import com.revature.pokedex.repository.CSVDexRepository;
import com.revature.pokedex.repository.SQLDexRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DexRepositoryTest {

    @Test
    public void getCSVCardTest() {
        CSVDexRepository testRepo = new CSVDexRepository("Core2021_CardListTest.csv");
        Mtg actual = testRepo.getCard("Dub");
        Mtg expected = new Mtg("Dub");
        Assertions.assertEquals(expected.getName(),actual.getName());
    }

//    @Test
//    public void getSQLCardTest() {
//        SQLDexRepository testRepo = new SQLDexRepository();
//        Mtg actual = Mtg.of().manaCost(2).name("Alpine Watchdog").type("Creature");
//        Assertions.assertEquals(actual);
//    }
}
