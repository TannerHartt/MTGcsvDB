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


    public DexServlet(DexRepository dexRepository) {
        this.dexRepository = dexRepository;
    }

    /**
     * Overriding the doGet method to print the names of cards on a new line
     * @param req Http request
     * @param resp Http response
     * @throws ServletException 
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput = req.getParameter("searchName");
        String set = req.getParameter("searchName");

        if (userInput != null) {
            Mtg result = dexRepository.getCard(userInput);
            resp.getWriter().println(result);
        } else {
            for (Mtg creature : dexRepository.getCards()) {
                resp.getWriter().println(creature + " ");
            }
        }
    }
}
