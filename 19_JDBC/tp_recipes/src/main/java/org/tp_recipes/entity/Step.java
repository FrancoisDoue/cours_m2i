package org.tp_recipes.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Step {
    private int id;
    private String description;
    private int idRecipe;
}
