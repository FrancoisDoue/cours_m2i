package com.example.ex4_recipes.repository;

import com.example.ex4_recipes.model.Category;
import com.example.ex4_recipes.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> getRecipesByCategory(Category category);
}
