package org.tp_recipes;

import org.tp_recipes.IHM.RecipeIHM;

public class Main {
    public static void main(String[] args) {
        try {
//            IngredientIHM.getInstance().start();
//            CategoryIHM.getInstance().start();
            RecipeIHM.getInstance().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}