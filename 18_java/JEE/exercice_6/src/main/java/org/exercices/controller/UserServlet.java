package org.exercices.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.exercices.entity.User;
import org.exercices.service.UserService;
import org.exercices.util.HibernateUtil;

import java.io.IOException;

@WebServlet(name = "userServlet", value = "/user/*")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService(HibernateUtil.getFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String pathInfo =  req.getPathInfo() == null ? "" : req.getPathInfo();

        if (pathInfo.equals("/logout")) {
            logout(req, resp);
            return;
        }
        if (session.getAttribute("isLogged") != null && (boolean) session.getAttribute("isLogged")) {
            resp.sendRedirect(req.getContextPath() + "/products");
            return;
        }
        switch (pathInfo) {
            case "/login" -> req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            case "/register" -> req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo =  req.getPathInfo() == null ? "" : req.getPathInfo();
        switch (pathInfo) {
            case "/login" -> login(req, resp);
            case "/register" -> register(req, resp);
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.register(
                req.getParameter("username"),
                req.getParameter("email"),
                req.getParameter("password")
        );
        if (user != null) {
            resp.sendRedirect(getServletContext().getContextPath()+"/user/login");
        } else {
            resp.sendRedirect(getServletContext().getContextPath()+"/user/register");
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean loginSuccess =  userService.login(
                req.getParameter("email"),
                req.getParameter("password")
        );
        if (loginSuccess) {
            HttpSession session = req.getSession();
            session.setAttribute("isLogged", true);
            resp.sendRedirect(getServletContext().getContextPath()+"/products");
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/user/login");
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("isLogged");
        resp.sendRedirect("login");
    }
}
