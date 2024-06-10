package org.exercoces.exercices;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Text servlet", value = "/servlet-text")
public class TextServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println("Page en texte brut (si si!)");
    }

}