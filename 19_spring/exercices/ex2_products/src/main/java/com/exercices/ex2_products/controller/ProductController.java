package com.exercices.ex2_products.controller;

import com.exercices.ex2_products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getProducts(Model model) {
        model.addAttribute("productList", productService.getAllProducts());
        return "productList";
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable UUID id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }

    @RequestMapping("/search")
    public String searchProducts(
            @RequestParam(value = "cat", required = false) String category,
            @RequestParam(value = "priceOver", required = false) Double priceOver,
            Model model
    ) {
        model.addAttribute("productList", productService.getAllProducts());
        if (category != null) {
            model.addAttribute("productList", productService.getProductsByCategory(category));
        }
        if (priceOver != null) {
            model.addAttribute("productList", productService.getProductsOverPrice(priceOver));
            System.out.println("on price over " + priceOver);
        }
        return "productList";
    }
}
