package org.design_patterns.exercices.exo_02_factory.abstract_classes;

public abstract class CuisineFactory {

    public abstract Ingredient createIngredient();
    public abstract CookingUstensil createUstensil();
    public abstract Dish createDish();

}
