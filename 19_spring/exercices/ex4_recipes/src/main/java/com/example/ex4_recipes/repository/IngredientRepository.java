package com.example.ex4_recipes.repository;

import com.example.ex4_recipes.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}
