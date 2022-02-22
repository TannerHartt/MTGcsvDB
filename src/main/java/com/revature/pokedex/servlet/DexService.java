package com.revature.pokedex.servlet;
import com.revature.pokedex.domain.Mtg;
import com.revature.pokedex.repository.DexRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class DexService extends HttpServlet{
    private DexRepository dexRepository;


    public DexService(DexRepository dexRepository ) {
        this.dexRepository = dexRepository;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput = req.getParameter("searchName");

        if (userInput != null) {
            Mtg result = dexRepository.getCard(userInput);
            Mtg second = dexRepository.getCard(userInput);
            resp.getWriter().println(result);
            resp.getWriter().println(second);
        } else {
            for (Mtg creature : dexRepository.getCards()) {
                resp.getWriter().println(creature);
            }
        }
    }
}