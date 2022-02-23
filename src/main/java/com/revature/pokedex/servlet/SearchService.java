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
                "     <h1>Magic The Gathering Search</h1>" +
                "    <form action='/cards' method='get'>\n" +
                "        <input type='name' name='searchName'/>\n" +
                "        <input type='submit' value='Search'/>\n" +
                "    " +
                "     <a href='cards'>See full list</a>\n" +
                "</form>\n" +
                "</Body>\n" +
                "</Html>";
        resp.getWriter().println(HTMLForm);
    }
}
