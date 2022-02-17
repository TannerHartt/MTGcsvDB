package com.revature.pokedex;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) {

        //DexRepository dexRepository = new DexRepository("mtgdata.csv");
        DexRepository dexRepository = new DexRepository("Core2021_CardList.csv");
        //InMemoryDexRepository dexRepository1 = new InMemoryDexRepository();
        DexService dexService = new DexService(dexRepository);
        SearchService sfService = new SearchService();


        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        //server.setPort(0);
        server.getConnector();
        server.addContext("", null);


        server.addServlet("","defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("","dexServlet", dexService).addMapping("/cards");
        server.addServlet("", "searchFormServlet", sfService).addMapping("/search");


        try{
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
