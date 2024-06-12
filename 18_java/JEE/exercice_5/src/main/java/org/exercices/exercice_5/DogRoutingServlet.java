package org.exercices.exercice_5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercices.entity.Dog;
import org.exercices.repository.impl.DogRepository;
import org.exercices.util.HibernateUtil;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "dog_routing_servlet", value = {"/dogs", "/dogs/*"})
public class DogRoutingServlet extends HttpServlet {

    private DogRepository dogRepository;

    @Override
    public void init() throws ServletException {
        dogRepository = new DogRepository(HibernateUtil.getFactory());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = (request.getPathInfo() == null || request.getPathInfo().isEmpty()) ? "" : request.getPathInfo();
        System.out.println(pathInfo);
        if (pathInfo.equals("/add")) {
            request.setAttribute("isReadonly", false);
            request.setAttribute("currentDog", new Dog());
            request.getRequestDispatcher("/WEB-INF/dogForm.jsp").forward(request, response);
            return;
        }
        if (pathInfo.startsWith("/details")) {
            int dogId = Integer.parseInt(pathInfo.split("/")[2]);
            request.setAttribute("isReadonly", true);
            request.setAttribute("currentDog", dogRepository.find(dogId));
            request.getRequestDispatcher("/WEB-INF/dogForm.jsp").forward(request, response);
            return;
        }
        request.setAttribute("dogList", dogRepository.findAll());
        request.getRequestDispatcher("/WEB-INF/dogList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dog doggo = new Dog(
                req.getParameter("name"),
                req.getParameter("breed"),
                LocalDate.parse(req.getParameter("birthday"))
        );
        dogRepository.create(doggo);
        resp.sendRedirect(getServletContext().getContextPath() + "/dogs");
    }
}