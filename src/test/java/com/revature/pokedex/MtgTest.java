package com.revature.pokedex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MtgTest {
    @Test
    public void constructorTest(){
        String name = "Shatterskull Smashing";
        Mtg card = new Mtg(name);
        card = new Mtg("Shatterskull Smashing", 2 , "Sorcery");
    }

    @Test
    public void builderTest() {
        Mtg actual = Mtg.of().id(1).name("Shatterskull Smashing").type("Sorcery");
        Assertions.assertEquals("Shatterskull Smashing", actual.getName());
        actual = Mtg.of().type("Sorcery").name("Shatterskull Smashing").id(2);
    }

    @Test
    public void nameTest() {
        Mtg card = new Mtg("Alpine Watchdog");
        Assertions.assertEquals(card.getName(), "Alpine Watchdog");
        card = new Mtg("Shatterskull Smashing");
        Assertions.assertEquals("Shatterskull Smashing", card.getName());
    }

}
