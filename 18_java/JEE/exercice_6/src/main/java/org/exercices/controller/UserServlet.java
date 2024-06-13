package org.exercices.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.exercices.service.UserService;
import org.exercices.util.HibernateUtil;

import java.io.IOException;

@WebServlet(name = "userServlet", value = {"/user", "/user/*"})
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService(HibernateUtil.getFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo =  req.getPathInfo() == null ? "" : req.getPathInfo();
        if (pathInfo.equals("/login")) {
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
        if (pathInfo.equals("/register")) {
            req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo =  req.getPathInfo() == null ? "" : req.getPathInfo();
        if (pathInfo.equals("/login")) {
            System.out.println(req.getParameter("email"));
            boolean loginSuccess =  userService.login(
                    req.getParameter("email"),
                    req.getParameter("password")
            );
            System.out.println("Is login successful? " + loginSuccess);
            if (loginSuccess) {
                HttpSession session = req.getSession();
                session.setAttribute("isLogged", true);
                resp.sendRedirect(req.getContextPath() + "/products");
            }
        }
        if (pathInfo.equals("/register")) {
            userService.register(
                req.getParameter("username"),
                req.getParameter("email"),
                req.getParameter("password")
            );
            resp.sendRedirect(getServletContext().getContextPath()+"/user/login");
        }
    }
}
