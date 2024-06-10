package org.demo_base.demo_base;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet MonServletHtml", value = "/toto")
public class MonServletHTML extends HttpServlet {

    private String prenom;

    @Override
    public void init() throws ServletException {
//        super.init();
        prenom = "toto";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet MonServletHTML</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + prenom + "</h1>");
        out.println("</body>");
    }
}
