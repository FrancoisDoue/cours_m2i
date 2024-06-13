package org.exercices.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercices.entity.Dog;
import org.exercices.service.DogService;
import org.exercices.util.HibernateUtil;

import java.io.IOException;

@WebServlet(name = "dog_routing_servlet", value = {"/dogs", "/dogs/*"})
public class DogRoutingServlet extends HttpServlet {

    private DogService dogService;

    @Override
    public void init() {
        dogService = new DogService(HibernateUtil.getFactory());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo() == null ? "" : request.getPathInfo();
        switch (pathInfo) {
            case "/details" -> showDetails(request, response);
            case "/add" -> addDog(request, response);
            case "/update" -> updateDog(request, response);
            case "/delete" -> deleteDog(request, response);
            default -> showDogs(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("update") != null ? request.getParameter("update") : "";
        Dog doggo = new Dog();
        doggo.setName(request.getParameter("name"));
        doggo.setBreed(request.getParameter("breed"));
        doggo.setBirthDate(request.getParameter("birthdate"));
        if (!idString.isEmpty()) {
            try {
                doggo.setId(Integer.parseInt(idString));
                dogService.updateDog(doggo);
            } catch (NumberFormatException e) {
                System.out.println("error: " + e.getMessage());
            }
        } else {
            dogService.createDog(doggo);
        }
        response.sendRedirect(getServletContext().getContextPath() + "/dogs");
    }

    private void showDogs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dogList", dogService.getAllDogs());
        request.getRequestDispatcher("/WEB-INF/dogList.jsp").forward(request, response);
    }

    private void showDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Dog dog = dogService.getDog(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("isReadonly", true);
            request.setAttribute("currentDog", dog);
            request.getRequestDispatcher("/WEB-INF/dogForm.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println("error: " + e.getMessage());
            response.sendRedirect(getServletContext().getContextPath() + "/dogs");
        }
    }

    private void addDog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isReadonly", false);
        request.setAttribute("currentDog", new Dog());
        request.getRequestDispatcher("/WEB-INF/dogForm.jsp").forward(request, response);
    }

    private void updateDog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String param = request.getParameter("id") != null ? request.getParameter("id") : "";
            request.setAttribute("isReadonly", false);
            Dog dog = dogService.getDog(Integer.parseInt(param));
            request.setAttribute("currentDog", dog);
            request.getRequestDispatcher("/WEB-INF/dogForm.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    private void deleteDog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            dogService.deleteDog(Integer.parseInt(request.getParameter("id")));
        } catch (NumberFormatException e) {
            System.out.println("error: " + e.getMessage());
        }
        response.sendRedirect(getServletContext().getContextPath() + "/dogs");
    }

}
