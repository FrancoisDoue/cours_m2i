package org.exercoces.exercices;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "bootstrap_2", value = "/bootstrap-2", initParams = {
        @WebInitParam(name = "test", value = "123"),
        @WebInitParam(name = "original2", value = "valeur2")
})
public class Bootstrap2Servlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        String test2 = config.getInitParameter("test");
        String original2 = config.getInitParameter("original2");
        System.out.println(original2 + " " + test2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String test = req.getParameter("test");
//        System.out.println(test);
        req.getRequestDispatcher("bootstrapPage2.jsp").forward(req, resp);
    }
}
