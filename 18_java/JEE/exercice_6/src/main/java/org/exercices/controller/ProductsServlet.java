package org.exercices.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercices.service.ProductService;
import org.exercices.util.HibernateUtil;

import java.io.IOException;

@WebServlet(name = "products", value = {"/products", "/products/*"})
public class ProductsServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init(ServletConfig config) {
        productService = new ProductService(HibernateUtil.getFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        System.out.println(session.getAttribute("isLogged"));
//        boolean loggedIn = session.getAttribute("isLogged") != null && (boolean) session.getAttribute("isLogged");
//        if (!loggedIn) {
//            res.sendRedirect(req.getContextPath() + "/user/login");
//            return;
//        }
        req.setAttribute("products", productService.getAllProducts());
        req.getRequestDispatcher("/WEB-INF/productList.jsp").forward(req, res);
    }

}
