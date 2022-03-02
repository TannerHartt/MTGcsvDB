package com.revature.pokedex.servlet;
import com.revature.pokedex.domain.Mtg;
import com.revature.pokedex.repository.CSVDexRepository;
import com.revature.pokedex.repository.DexRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RisingServlet extends HttpServlet {
    private DexRepository dexRepository;

    public RisingServlet(DexRepository dexRepository) {
        this.dexRepository = dexRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput = req.getParameter("searchName");

        if (userInput != null) {
            Mtg result = dexRepository.getCard(userInput);
            resp.getWriter().println(result);
        } else {
            //resp.getWriter().println("<table><tr><td>Creature Name</td><td>Mana Cost</td><td>Type</td></tr>");
            for (Mtg creature : dexRepository.getCards()) {
                resp.getWriter().println(creature + " ");
            }
            resp.getWriter().println("\n");
        }
    }
}
