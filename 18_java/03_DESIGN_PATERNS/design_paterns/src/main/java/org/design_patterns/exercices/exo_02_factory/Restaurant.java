package org.design_patterns.exercices.exo_02_factory;

import org.design_patterns.exercices.exo_02_factory.abstract_classes.CookingUstensil;
import org.design_patterns.exercices.exo_02_factory.abstract_classes.CuisineFactory;
import org.design_patterns.exercices.exo_02_factory.abstract_classes.Dish;
import org.design_patterns.exercices.exo_02_factory.abstract_classes.Ingredient;

public class Restaurant {

    private Ingredient ingredient;
    private CookingUstensil cookingUstensil;
    private Dish dish;

    public void setFactory(CuisineFactory factory) {
        ingredient = factory.createIngredient();
        cookingUstensil = factory.createUstensil();
        dish = factory.createDish();
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public CookingUstensil getCookingUstensil() {
        return cookingUstensil;
    }

    public Dish getDish() {
        return dish;
    }
}
