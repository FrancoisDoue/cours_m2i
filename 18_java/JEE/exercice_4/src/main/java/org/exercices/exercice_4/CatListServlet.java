package org.exercices.exercice_4;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercices.entity.Cat;
import org.exercices.service.CatService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "cat-list", value = "/cat-list")
public class CatListServlet extends HttpServlet {

    List<Cat> cats;

    @Override
    public void init() throws ServletException {
        cats = new CatService().getCats();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cats", cats);
        request.getRequestDispatcher("/cat-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catName = req.getParameter("name");
        String catRace = req.getParameter("race");
        String catMeat = req.getParameter("meat");
        String catBirthday = req.getParameter("birthday");
        new CatService().add(catName, catRace, catMeat, catBirthday);
        resp.sendRedirect("cat-list");
    }
}
