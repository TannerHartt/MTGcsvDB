package com.revature.pokedex.servlet;

import com.revature.pokedex.domain.Mtg;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String HTMLForm = "<Html>\n" +
                "<Head>\n" +
                "    <Title>Search MTG Cards" +
                "</Title>\n" +
                "</Head>\n" +
                "<Body>\n" +
                "        <center><img src=https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Magicthegathering-logo.svg/512px-Magicthegathering-logo.svg.png?20160501122627>" +
                "        <h1>Magic The Gathering Search</h1>" +
                "        <form action='/cards' method='get'>\n" +
                "        <input type='name' name='searchName'/>\n" +
                "        <input type='submit' value='Search'/>\n" +
                "    "  +
                "     <a href='cards'>See full Core 2021 set list</a>\n" +
                "     <a href='core2021'>See full Zendikar Rising set list</a\n" +
                "</form>\n" +
                "</Body>\n" +
                "</Html>";
        resp.getWriter().println(HTMLForm);
    }
}
