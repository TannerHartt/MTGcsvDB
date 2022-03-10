package com.revature.pokedex.servlet;

import com.revature.pokedex.domain.Mtg;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchService extends HttpServlet {

    /**
     * Overriding the doGet method to print how the search page will look
     * @param req Http request
     * @param resp  Http Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String HTMLForm = "<Html>\n" +
                "<Head>\n" +
                "    <Title>Search MTG Cards" +
                // title, meta, link
                "</Title>\n" +
                "</Head>\n" +
                "<Body>\n" +
                // div , a , p , h1-h6
                "         <br><center><img src=https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Magicthegathering-logo.svg/512px-Magicthegathering-logo.svg.png?20160501122627>" +
                "         <h1>Magic The Gathering Search</h1>" +
                "         <form action='/all' method='get'>\n" +
                "               <input type='name' name='searchName'/>\n" +
                "               <input type='submit' value='Search'/>\n" +
                "         <form action='/rising' method='get'>\n" +
                "   <br>  "  +
                "   <br>  <a href='all'>See list of all cards</a\n <br>" +
                "   <br>  <a href='cards'>See full Core 2021 set list</a>\n " +
                "   <br>  <a href='rising'>See full Zendikar Rising set list</a>\n <br>" +
                "   <body style='background-image: url(img.jpg); background-repeat:no-repeat; background-size: cover'> " +
                "   <br><br><img src=https://product-images.tcgplayer.com/fit-in/400x558/48139.jpg>" +
                "</form>\n" +
                "</Body>\n" +
                "</Html>";
        resp.getWriter().println(HTMLForm);
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
