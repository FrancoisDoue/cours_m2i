package org.design_patterns.exercices.exo_02_factory;

import org.design_patterns.exercices.exo_02_factory.abstract_classes.CookingUstensil;
import org.design_patterns.exercices.exo_02_factory.abstract_classes.CuisineFactory;
import org.design_patterns.exercices.exo_02_factory.abstract_classes.Dish;
import org.design_patterns.exercices.exo_02_factory.abstract_classes.Ingredient;

public class Restaurant {

    private Ingredient ingredient;
    private CookingUstensil cookingUstensil;
    private Dish dish;

    public Restaurant(CuisineFactory cuisineFactory) {
        setFactory(cuisineFactory);
    }

    public void setFactory(CuisineFactory cuisineFactory) {
        ingredient = cuisineFactory.createIngredient();
        cookingUstensil = cuisineFactory.createUstensil();
        dish = cuisineFactory.createDish();
    }

    public void make() {
        ingredient.prepare();
        cookingUstensil.use();
        dish.serve();
    }
}
