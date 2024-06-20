package tp_hopital.wep_application.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tp_hopital.wep_application.service.AuthService;

import java.io.IOException;

@WebServlet(name = "auth", value = "/auth/*")
public class AuthServlet extends HttpServlet {

    private AuthService authService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        authService = new AuthService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo() == null ? "" : req.getPathInfo();
        HttpSession session = req.getSession();
        if (session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn")) {
            System.out.println("Login ok");
            resp.sendRedirect(req.getContextPath() + "/patient");
            return;
        }
        switch (pathInfo) {
            case "/connect" -> connect(req, resp);
            default -> req.getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void connect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (authService.login(req.getParameter("login"), req.getParameter("password"))) {
            HttpSession session = req.getSession();
            System.out.println("On login success");
            session.setAttribute("isLoggedIn", true);
        }
        resp.sendRedirect(req.getContextPath()+"/auth/login");
    }
}
