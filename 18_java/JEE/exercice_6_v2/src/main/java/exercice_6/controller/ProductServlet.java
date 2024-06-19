package exercice_6.controller;

import exercice_6.entity.Product;
import exercice_6.service.ProductService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "product", value = "/product/*")
public class ProductServlet extends HttpServlet {

    ProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo() == null ? "" : req.getPathInfo();
        switch (pathInfo) {
            case "/add" -> {}
            case "/edit" -> {}
            case "/delete" -> {}
            default -> showProductList(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void showProductList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("importJsp", "productList");
        req.setAttribute("products", new ArrayList<Product>());
        req.getRequestDispatcher("/WEB-INF/product.jsp").forward(req, resp);
    }
}
