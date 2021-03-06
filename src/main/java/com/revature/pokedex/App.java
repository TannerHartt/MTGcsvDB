package com.revature.pokedex;
import com.revature.pokedex.repository.CSVDexRepository;
import com.revature.pokedex.repository.DexRepository;
import com.revature.pokedex.servlet.*;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        /*
        Setting up instances of the CSVDexRepository file and passing in my desired csv file to be loaded and parsed
         */
        DexRepository dexRepository = new CSVDexRepository("Core2021_CardList.csv");;
        DexRepository zendikarRising = new CSVDexRepository("ZendikarRisingSetList.csv");
        DexRepository allList = new CSVDexRepository("historyOfSet.csv");
        DexRepository typesList = new CSVDexRepository("cards.csv");
        //dexRepository = new InMemoryDexRepository();
        DexServlet dexServlet = new DexServlet(dexRepository);
        RisingServlet risingServlet = new RisingServlet(zendikarRising);
        AllCardsServlet allCardsServlet = new AllCardsServlet(allList);
        SearchService sfService = new SearchService();

        /*
           Initializes a new instance of the Tomcat class making a server, then sets the base directory so the server
           knows where the files are stored.
           Adds servlets that run the specified class and adds a mapping to use in the url to run given class.
           Sets server port to a random, available port using setPort(0);
         */
        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(0);
        server.getConnector();
        server.addContext("", null);
        server.addServlet("","defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("","dexServlet", dexServlet).addMapping("/cards");
        server.addServlet("", "dexServlet1", risingServlet).addMapping("/rising");
        server.addServlet("", "dexServlet2", allCardsServlet).addMapping("/all");
        server.addServlet("", "searchFormServlet", sfService).addMapping("/search");

        /*
          Starts server and provides a link to the home page of the server
         */
        try{
            server.start();
            System.out.println("Server is running on http://localhost:" + server.getConnector().getLocalPort() + "/search");
            server.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

//        try {
//            searchReturnAll();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public static void searchReturnAll() throws IOException {

        String file = "src/Core2021_CardList.csv";
        String searchTerm = "Dub";
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
            for  (String [] aData : data) {
                for (String value : aData) {
                    if (value.equals(searchTerm)) {
                        System.out.println(Arrays.toString(aData));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
