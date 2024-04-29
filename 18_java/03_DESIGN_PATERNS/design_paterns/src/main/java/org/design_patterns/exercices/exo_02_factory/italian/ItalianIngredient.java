package org.design_patterns.exercices.exo_02_factory.italian;

import org.design_patterns.exercices.exo_02_factory.abstract_classes.Ingredient;

public class ItalianIngredient extends Ingredient {

    @Override
    public void prepare() {
        System.out.println("Vous préparez des pâtes");
    }
}
