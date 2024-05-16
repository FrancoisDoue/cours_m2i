package org.tp_recipes.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientRecipe {
    private int id;
    private int idRecipe;
    private int idIngredient;
    private int quantity;
}
