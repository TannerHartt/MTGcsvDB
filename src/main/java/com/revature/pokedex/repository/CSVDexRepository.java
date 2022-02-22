package com.revature.pokedex.repository;

import com.revature.pokedex.domain.Mtg;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVDexRepository implements DexRepository{
    private List<Mtg> cards = new ArrayList<>();
    private InputStream file;

    /**
     * Constructor requiring a path to a csv file, searches system for filename
     * @param filename - CSV file to parse
     */
    public CSVDexRepository(String filename){
        this.cards = new ArrayList<>();
        this.file = getClass().getClassLoader().getResourceAsStream(filename);
        loadFile();

    }

    /**
     * Reads and parses the Core2021_CardList.csv, loads each new card on a new line.
     */
    private void loadFile() {
        Scanner sc = new Scanner(this.file);
        sc.useDelimiter("\n");
        while(sc.hasNext()) {
            String[] cardColumns = sc.next().split(",");
            Mtg temp = new Mtg(cardColumns[0]);
            this.cards.add(temp);
        }
    }

    /**
     * getCard takes in a name
     * @param name
     * @return
     */
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
