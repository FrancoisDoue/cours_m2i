package org.demo_base.demo_base;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Mon servlet JSP" , value = "/monservlet-jsp")
public class JSPServlet extends HttpServlet {

    private String firstname;
    private String lastname;

    @Override
    public void init() throws ServletException {
        super.init();
        firstname = "Georges";
        lastname = "Abitbol";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        getServletContext().getRequestDispatcher("/monservlet.jsp").forward(request, response);
    }
}
