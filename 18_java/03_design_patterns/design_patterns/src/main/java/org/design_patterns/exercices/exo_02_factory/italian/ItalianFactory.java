package org.design_patterns.exercices.exo_02_factory.italian;

import org.design_patterns.exercices.exo_02_factory.abstract_classes.CuisineFactory;

public class ItalianFactory extends CuisineFactory {

    @Override
    public ItalianIngredient createIngredient() {
        return new ItalianIngredient();
    }

    @Override
    public ItalianUstensil createUstensil() {
        return new ItalianUstensil();
    }

    @Override
    public ItalianDish createDish() {
        return new ItalianDish();
    }
}
