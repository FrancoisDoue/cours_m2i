package org.exercices.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.exercices.entity.Product;
import org.exercices.service.ProductService;
import org.exercices.util.HibernateUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "products", value = "/products/*")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class ProductsServlet extends HttpServlet {

    private ProductService productService;
    private boolean loggedIn = false;
    String absImagePath;

    @Override
    public void init(ServletConfig config) {
        productService = new ProductService(HibernateUtil.getFactory());
        absImagePath = config.getServletContext().getRealPath("/")+"images";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        loggedIn = session.getAttribute("isLogged") != null && (boolean) session.getAttribute("isLogged");
        loggedIn = true;
        String pathInfo =  req.getPathInfo() == null ? "" : req.getPathInfo();
        req.setAttribute("isLogged", loggedIn);
        switch (pathInfo) {
            case "/add" -> addProduct(req, res);
            case "/update" -> updateProduct(req, res);
            case "/remove" -> removeProduct(req, res);
            default -> showProducts(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("id") != null ? req.getParameter("id") : "";
        if (!loggedIn) {
            resp.sendRedirect(req.getContextPath() + "/user/login");
            return;
        }

        Product product = (productId.isEmpty()) ? new Product() : productService.getProduct(Integer.parseInt(productId));

        product.setBrand(req.getParameter("brand"));
        product.setRef(req.getParameter("ref"));
        product.setPrice(Double.parseDouble(req.getParameter("price")));
        product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        product.setBuyDate(LocalDate.parse(req.getParameter("buyDate")));

        Part filePart = req.getPart("img");
        if (filePart != null) {
            String imgName = System.currentTimeMillis() + "." + filePart.getSubmittedFileName().split("\\.")[1];
            String relPath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/images";
            File file = new File(absImagePath);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                filePart.write(absImagePath+File.separator+imgName);
                product.setImageUrl(relPath+"/"+imgName);
            } catch (IOException e) {
                System.out.println("error = " + e);
            }
        }
        if (productId.isEmpty()) {
            productService.createProduct(product);
        } else {
            productService.update(product);
        }
        resp.sendRedirect(req.getContextPath() + "/products");
    }

    private boolean checkIsNotLogged(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!loggedIn) {
            resp.sendRedirect(req.getContextPath() + "/user/login");
            return true;
        }
        return false;
    }

    protected void showProducts(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("products", loggedIn ? productService.getAllProducts() : new ArrayList<Product>());
        req.setAttribute("component", "showProducts");
        req.getRequestDispatcher("/WEB-INF/products.jsp").forward(req, res);
    }

    protected void addProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (checkIsNotLogged(req, res)) return;
        req.setAttribute("component", "formProduct");
        req.setAttribute("isEdit", false);
        req.setAttribute("currentProduct", new Product());
        req.getRequestDispatcher("/WEB-INF/products.jsp").forward(req, res);
    }

    protected void updateProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (checkIsNotLogged(req, res)) return;
        String productId = req.getParameter("id") != null ? req.getParameter("id") : "";
        Product product = productService.getProduct(Integer.parseInt(productId));
        req.setAttribute("isEdit", true);
        req.setAttribute("currentProduct", product);
        req.setAttribute("component", "formProduct");
        req.getRequestDispatcher("/WEB-INF/products.jsp").forward(req, res);
    }

    protected void removeProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (checkIsNotLogged(req, res)) return;
        String productId = req.getParameter("id") != null ? req.getParameter("id") : "";
        productService.deleteProduct(Integer.parseInt(productId));
        res.sendRedirect(req.getContextPath() + "/products");
    }

}
