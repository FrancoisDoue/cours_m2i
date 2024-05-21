package org.tp_recipes;

import org.tp_recipes.IHM.impl.CategoryIHM;
import org.tp_recipes.IHM.impl.IngredientIHM;
import org.tp_recipes.IHM.impl.RecipeIHM;

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