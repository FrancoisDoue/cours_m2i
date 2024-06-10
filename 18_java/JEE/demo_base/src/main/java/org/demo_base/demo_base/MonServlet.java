package org.demo_base.demo_base;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Mon servlet", value = "/monservlet")
public class MonServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("monservlet est lancé");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Une requête de type GET à été envoyé à /monservlet");

        PrintWriter out = res.getWriter();
//        res.setContentType("Application/JSON");
        res.setContentType("text/plain");
        out.println("{\"monservlet\":\"monservlet\"}");
    }


    @Override
    public void destroy() {
        System.out.println("Fin de la requête");
    }
}
