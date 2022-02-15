package com.revature.pokedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class DefaultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getPathInfo().replaceFirst("/" , "");
        if(filename.equals("")) filename = "index.html";

        InputStream file = getClass().getClassLoader().getResourceAsStream(filename);
        if (file == null) {
            resp.setStatus(404);
            resp.getWriter().println("File not found");
        }
        IOUtils.copy(file, resp.getOutputStream());
    }
}
