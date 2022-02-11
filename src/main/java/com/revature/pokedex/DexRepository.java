package com.revature.pokedex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DexRepository {
    private List<String> cards = new ArrayList<>();
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
            this.cards.add(sc.next());
        }
    }

    public List<String> getCards() {
        return cards;
    }
}