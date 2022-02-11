package com.revature.pokedex;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class DexService extends HttpServlet{
    private DexRepository dexRepository;

    public DexService(DexRepository dexRepository) {
        this.dexRepository = dexRepository;
    }
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (String creature : dexRepository.getCards()) {
            resp.getWriter().println(creature);

        }
    }
}
