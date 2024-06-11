package org.exercices.exercice_11_06;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercices.entity.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "list-person", value = "/list-person")
public class ListPersonServlet extends HttpServlet {

    private List<Person> persons;

    @Override
    public void init() throws ServletException {
        super.init();
        persons = new ArrayList<>(List.of(
                new Person("François", "Doué", 30),
                new Person("Florian", "Delafosse", 30),
                new Person("Alexandre", "Messuve", 27)
        ));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
