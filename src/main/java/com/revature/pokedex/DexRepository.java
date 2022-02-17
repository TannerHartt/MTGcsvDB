package com.revature.pokedex;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DexRepository {
    private List<Mtg> cards = new ArrayList<>();
    private InputStream file;

    public DexRepository(String filename){
        this.cards = new ArrayList<>();
        this.file = getClass().getClassLoader().getResourceAsStream(filename);
        loadFile();

    }

    private void loadFile() {
        Scanner sc = new Scanner(this.file);
        sc.useDelimiter("\n");
        while(sc.hasNext()) {
            String[] cardColumns = sc.next().split(",");
            Mtg temp = new Mtg(cardColumns[0]);
            this.cards.add(temp);
        }
    }
    public Mtg getCard(String name){
        Mtg result = null;
      for (Mtg mtg : this.cards){
          if (mtg.getName().equals(name)) {
              result = mtg;
          }
      }
      return result;
    }

    public List<Mtg> getCards() {
        return cards;
    }
}
