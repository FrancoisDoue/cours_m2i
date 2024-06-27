package com.example.ex4_recipes.controller;

import com.example.ex4_recipes.model.Category;
import com.example.ex4_recipes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category-list";
    }

    @PostMapping
    public String submitCategory(Category category, Model model) {
        categoryService.createCategory(category);
        System.out.println(category);
        return "redirect:/categories/"+category.getId();
    }

    @GetMapping("/{id}")
    public String getOneCategory(Model model, @PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "category";
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category-form";
    }

}
