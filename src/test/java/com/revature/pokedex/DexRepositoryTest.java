package com.revature.pokedex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DexRepositoryTest {

    @Test
    public void getCardTest() {
        DexRepository testRepo = new DexRepository("mtgdatatest.csv");
        String expectedCard = testRepo.getCard("Anticipate");
        Assertions.assertEquals(expectedCard,"mz,Ikoria: Lair of Behemoths,5,10,Anticipate,Common,Instant,,,,1,Blue,2,Regular,0,,1,0.15");
        
    }


}
