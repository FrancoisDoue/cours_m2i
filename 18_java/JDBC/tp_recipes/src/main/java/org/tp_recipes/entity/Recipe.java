package org.tp_recipes.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        StringBuilder ingredientsString = new StringBuilder();
        StringBuilder stepsString = new StringBuilder();
        if (ingredients == null) {
            ingredientsString.append("No ingredients found");
        } else {
            ingredients.forEach(ingredient -> ingredientsString.append(String.format(
                    "\t- %s x%d\n", ingredient.getName(), ingredient.getQuantity()
            )));
        }
        if (steps == null) {
            stepsString.append("No steps found");
        } else {
            AtomicInteger i = new AtomicInteger(1);
            steps.forEach(step -> stepsString.append(String.format(
                        "%d. - %s\n", i.getAndIncrement(), step.getDescription()
            )));
        }
        return String.format("""
                #%s - %s
                Préparation: %d | Cuisson: %d | Difficulté: %d
                %s
                Etapes:
                %s
                """, id, title, preparationTime, cookingTime, difficulty, ingredientsString, stepsString);
    }
}
