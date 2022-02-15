package com.revature.pokedex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MtgTest {
    @Test
    public void constructorTest(){
        String name = "Shatterskull Smashing";
        Mtg card = new Mtg(name);
    }

}
