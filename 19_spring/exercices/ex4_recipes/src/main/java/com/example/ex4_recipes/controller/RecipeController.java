package com.example.ex4_recipes.controller;

import com.example.ex4_recipes.model.Ingredient;
import com.example.ex4_recipes.model.Recipe;
import com.example.ex4_recipes.model.Step;
import com.example.ex4_recipes.service.CategoryService;
import com.example.ex4_recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;


    @Autowired
    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String recipeList(Model model) {
        List<Recipe> recipeList = recipeService.getAllRecipes();
        System.out.println(recipeList);
        model.addAttribute("recipeList", recipeList);
        return "recipe-list";
    }

    @PostMapping
    public String submitRecipe(@ModelAttribute("recipe") Recipe recipe, Model model) {
        recipeService.createRecipe(recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/{id}")
    public String recipeDetail(@PathVariable int id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        return "recipe";
    }

    @GetMapping("/add")
    public String addRecipe(Model model) {
        String s = "";
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "recipe-form";
    }
    @GetMapping("/update/{id}")
    public String updateRecipe(@PathVariable int id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "recipe-form";
    }




}
