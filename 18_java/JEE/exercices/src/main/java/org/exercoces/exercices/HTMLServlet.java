package org.exercoces.exercices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Html servlet", value = "/servlet-html")
public class HTMLServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Html servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Ceci est une page HTML</h1>");
        out.println("<h3>Avec une sublime mise en page</h3>");
        out.println("</body>");
    }
}
