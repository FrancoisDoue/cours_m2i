package com.example.ex4_recipes.service;

import com.example.ex4_recipes.model.Recipe;
import com.example.ex4_recipes.repository.IngredientRepository;
import com.example.ex4_recipes.repository.RecipeRepository;
import com.example.ex4_recipes.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final StepRepository stepRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository ,StepRepository stepRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.stepRepository = stepRepository;
    }

    public List<Recipe> getAllRecipes() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    public Recipe getRecipeById(int id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public Recipe createRecipe(Recipe recipe) {
        ingredientRepository.saveAll(recipe.getIngredients());
        stepRepository.saveAll(recipe.getSteps());
        return recipeRepository.save(recipe);
    }


}
