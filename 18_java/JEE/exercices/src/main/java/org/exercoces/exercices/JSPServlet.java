package org.exercoces.exercices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "servlet_jsp", value = "/servlet-jsp")
public class JSPServlet extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Ceci est une page avec jsp";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("JSPex01.jsp").forward(request, response);
    }
}
