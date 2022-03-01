package com.revature.pokedex.servlet;
import com.revature.pokedex.domain.Mtg;
import com.revature.pokedex.repository.CSVDexRepository;
import com.revature.pokedex.repository.DexRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DexServlet extends HttpServlet{
    private DexRepository dexRepository;
    private DexRepository secondFile;


    public DexServlet(DexRepository dexRepository, DexRepository secondFile) {
        this.dexRepository = dexRepository;
        this.secondFile = secondFile;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput = req.getParameter("searchName");
        String set = req.getParameter("set");



        if (userInput != null) {
            Mtg result = dexRepository.getCard(userInput);
            Mtg second = secondFile.getCard((userInput));
            resp.getWriter().println(result);
            resp.getWriter().println(second);
        } else {
            //resp.getWriter().println("<table><tr><td>Creature Name</td><td>Mana Cost</td><td>Type</td></tr>");

            for (Mtg creature : dexRepository.getCards()) {
                resp.getWriter().println(creature + " ");
            }
            resp.getWriter().println("\n");
            for (Mtg creature : secondFile.getCards()) {
                    resp.getWriter().println(creature + " ");
            }
        } // Print every other array element on a new line
    }
}
