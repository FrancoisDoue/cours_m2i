package org.design_patterns.exercices.exo_02_factory.mexican;

import org.design_patterns.exercices.exo_02_factory.abstract_classes.Ingredient;

public class MexicanIngredient extends Ingredient {

    @Override
    public void prepare() {
        System.out.println("Vous preparez des piments");
    }
}
