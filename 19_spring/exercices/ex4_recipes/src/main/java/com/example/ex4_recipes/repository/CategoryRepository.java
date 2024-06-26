package com.example.ex4_recipes.repository;

import com.example.ex4_recipes.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
