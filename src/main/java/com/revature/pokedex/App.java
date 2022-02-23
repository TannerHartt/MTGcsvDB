package com.revature.pokedex;
import com.revature.pokedex.repository.CSVDexRepository;
import com.revature.pokedex.repository.DexRepository;
import com.revature.pokedex.servlet.DefaultServlet;
import com.revature.pokedex.servlet.DexServlet;
import com.revature.pokedex.servlet.SearchService;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) {

        DexRepository dexRepository;
        //dexRepository = new DexRepository("mtgdata.csv");
        dexRepository = new CSVDexRepository("Core2021_CardList.csv");
        //dexRepository  = new CSVDexRepository("ZendikarRisingSetList.csv");

        //dexRepository = new InMemoryDexRepository();
        DexServlet dexServlet = new DexServlet(dexRepository);
        SearchService sfService = new SearchService();


        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(0);
        server.getConnector();
        server.addContext("", null);

        server.addServlet("","defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("","dexServlet", dexServlet).addMapping("/cards");
        server.addServlet("", "searchFormServlet", sfService).addMapping("/search");


        try{
            server.start();
            System.out.println("Server is running on http://localhost:" + server.getConnector().getLocalPort() + "/search");
            server.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
