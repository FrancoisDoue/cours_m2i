package org.tp_recipes.entity;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class Recipe {
    private int id;
    private String title;
    private int preparationTime;
    private int cookingTime;
    private int difficulty;
    private Category category;
    private List<Ingredient> ingredients;
    private List<Step> steps;
    private List<Comment> comments;

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", preparationTime=" + preparationTime +
                ", cookingTime=" + cookingTime +
                ", category=" + category +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                ", comments=" + comments +
                '}';
    }
}
