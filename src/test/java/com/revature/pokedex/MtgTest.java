package com.revature.pokedex;

import com.revature.pokedex.domain.Mtg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MtgTest {
    @Test
    public void constructorTest(){
        // Card Name,Card Types,CMC,Color,Rarity
        String name = "Shatterskull Smashing";
        Mtg card = new Mtg(name);
        card = new Mtg("Shatterskull Smashing", 2 , "Sorcery");
    }

    @Test
    public void builderTest() {
        Mtg actual = Mtg.of().manaCost(1).name("Shatterskull Smashing").type("Sorcery");
        Assertions.assertEquals("Shatterskull Smashing", actual.getName());
        actual = Mtg.of().type("Sorcery").name("Shatterskull Smashing").manaCost(2);
    }

    @Test
    public void nameTest() {
        Mtg card = new Mtg("Alpine Watchdog");
        Assertions.assertEquals(card.getName(), "Alpine Watchdog");
        card = new Mtg("Shatterskull Smashing");
        Assertions.assertEquals("Shatterskull Smashing", card.getName());
    }

//    @Test
//    public void comparatorTest(Mtg o1, Mtg o2) {
//        List<Mtg> cardList = Arrays.asList(
//                Mtg.of().name("Opt").type("Instant").manaCost(1),
//                Mtg.of().name("Opt").type("Instant").manaCost(2),
//                Mtg.of().name("Revitalize").type("").manaCost(1),
//                Mtg.of().name("Opt").type("Instant").manaCost(1));
//
//        System.out.println(cardList.toString());
//
//        cardList.sort(null);
//        System.out.println(cardList.toString());
//
//        cardList.sort(new Comparator<Mtg>() {
//                          @Override
//                          public int compare(Mtg o1, Mtg o2) {
//                              return Integer.compare(o1.getName().length(), o2.getName().length());
//                          }
//                      });
//
//
//        cardList.sort((Comparator<? super Mtg>) (Mtg o1, Mtg o2) -> {
//            return Integer.compare(o1.getName().length(), o2.getName().length());
//        });
//                System.out.println(cardList.toString());
//    }
}
