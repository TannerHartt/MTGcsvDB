package com.revature.pokedex;
import java.io.File;

public class App {
    public static void main(String[] args) {
        DexRepository dexRepository = new DexRepository("mtgdata.csv");
        DexService dexService = new DexService(dexRepository);
        DexServer dexServer = new DexServer(dexService);


    }



}
