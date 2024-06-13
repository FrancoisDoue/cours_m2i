package org.exercices.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercices.entity.Dog;
import org.exercices.repository.impl.DogRepository;
import org.exercices.service.DogService;
import org.exercices.util.HibernateUtil;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "dog_routing_servlet", value = {"/dogs", "/dogs/*"})
public class DogRoutingServlet extends HttpServlet {

    private DogService dogService;

    @Override
    public void init() {
        dogService = new DogService(HibernateUtil.getFactory());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo() == null ? "" : request.getPathInfo();
        System.out.println(pathInfo.isEmpty() ? "pathInfo is empty" : pathInfo);
        switch (pathInfo) {
            case "/add" -> addDog(request, response);
            case "/update" -> updateDog(request, response);
            case "/details" -> {}
            default -> {

                showDog(request, response);
            }
        }
    }

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

    private void showDog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dogList", dogService.getAllDogs());
        request.getRequestDispatcher("/WEB-INF/dogList.jsp").forward(request, response);
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

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String pathInfo = (request.getPathInfo() == null || request.getPathInfo().isEmpty()) ? "" : request.getPathInfo();
//        String mode = (request.getParameter("mode") != null) ? request.getParameter("mode") : "";
//        if (mode.equals("remove")) {
//            int dogId = Integer.parseInt(pathInfo.split("/")[1]);
//            System.out.println(dogId);
//            dogRepository.delete(dogRepository.find(dogId));
//            response.sendRedirect(getServletContext().getContextPath() + "/dogs");
//            return;
//        }
//        if (pathInfo.equals("/add")) {
//            request.setAttribute("isReadonly", false);
//            request.setAttribute("currentDog", new Dog());
//            request.getRequestDispatcher("/WEB-INF/dogForm.jsp").forward(request, response);
//            return;
//        }
//        if (pathInfo.startsWith("/details")) {
//            try {
//                int dogId = Integer.parseInt(pathInfo.split("/")[2]);
//                request.setAttribute("isReadonly", true);
//                request.setAttribute("currentDog", dogRepository.find(dogId));
//                request.getRequestDispatcher("/WEB-INF/dogForm.jsp").forward(request, response);
//            } catch ( NumberFormatException e) {
//                response.sendRedirect(getServletContext().getContextPath() + "/dogs");
//            }
//            return;
//        }
//        if (pathInfo.startsWith("/update")) {
//            try {
//                int dogId = Integer.parseInt(pathInfo.split("/")[2]);
//                request.setAttribute("isReadonly", false);
//                request.setAttribute("currentDog", dogRepository.find(dogId));
//                request.getRequestDispatcher("/WEB-INF/dogForm.jsp").forward(request, response);
//            } catch ( NumberFormatException e) {
//                response.sendRedirect(getServletContext().getContextPath() + "/dogs");
//            }
//        }
//        request.setAttribute("dogList", dogRepository.findAll());
//        request.getRequestDispatcher("/WEB-INF/dogList.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Dog doggo;
////        System.out.println(req.getParameter("mode") + " " + req.getParameter("id") + " " +req.getParameter("birthday"));
//        if (req.getParameter("mode") != null && req.getParameter("mode").equals("update")) {
//            doggo = dogRepository.find(Integer.parseInt(req.getParameter("id")));
//            doggo.setName(req.getParameter("name"));
//            doggo.setBreed(req.getParameter("breed"));
//            doggo.setBirthDate(LocalDate.parse(req.getParameter("birthday")));
//            dogRepository.update(doggo);
//        } else {
//            doggo = new Dog(
//                    req.getParameter("name"),
//                    req.getParameter("breed"),
//                    LocalDate.parse(req.getParameter("birthday"))
//            );
//            dogRepository.create(doggo);
//        }
//        resp.sendRedirect(getServletContext().getContextPath() + "/dogs");
//    }
//

}
