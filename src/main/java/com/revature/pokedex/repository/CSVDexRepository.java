package com.revature.pokedex.repository;

import com.revature.pokedex.domain.Mtg;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVDexRepository implements DexRepository{
    private List<Mtg> cards = new ArrayList<>();
    private List<Mtg> types = new ArrayList<>();
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
     * A utility method to load in a CSV and add the first element to a list
     */
    private void loadFile() {
        Scanner sc = new Scanner(this.file);
        sc.useDelimiter("\n");
        while(sc.hasNext()) {
            String[] cardColumns = sc.next().split(",");
            Mtg temp = new Mtg(cardColumns[0]);
            Mtg type = new Mtg(cardColumns[1]);
            this.cards.add(temp);
            //this.cards.add(type);
        }
    }

    // Niche load method I used for a specific csv file

//    private void loadTypesFile() {
//        Scanner sc = new Scanner(this.file);
//        sc.useDelimiter("\n");
//        while(sc.hasNext()) {
//            String[] cardColumns = sc.next().split(",");
//            Mtg temp = new Mtg(cardColumns[1]);
//            this.cards.add(temp);
//        }
//    }

    /**
     * getCard takes in a card name and searches through the object arraylist cards for the desired card object.
     * @param name card name to search for.
     * @return the card object with the specified name.
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
    public List<Mtg> getTypes() {
        return types;
    }
}
