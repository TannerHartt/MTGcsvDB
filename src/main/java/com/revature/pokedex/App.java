package com.revature.pokedex;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class App {
    public static void main(String[] args) {
        DexRepository dexRepository = new DexRepository("mtgdata.csv");
        DexService dexService = new DexService(dexRepository);
        DexServer dexServer = new DexServer(dexService);
        SearchService sfService = new SearchService();

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.getConnector();
        server.addContext("", null);
        server.addServlet("","dexServlet", dexService).addMapping("/cards");
        server.addServlet("", "searchFormServlet", sfService).addMapping("/search");
        try{
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
