package org.design_patterns.exercices.exo_02_factory.mexican;

import org.design_patterns.exercices.exo_02_factory.abstract_classes.CookingUstensil;
import org.design_patterns.exercices.exo_02_factory.abstract_classes.CuisineFactory;
import org.design_patterns.exercices.exo_02_factory.abstract_classes.Dish;
import org.design_patterns.exercices.exo_02_factory.abstract_classes.Ingredient;

public class MexicanFactory extends CuisineFactory {

    @Override
    public MexicanIngredient createIngredient() {
        return new MexicanIngredient();
    }

    @Override
    public MexicanUstensil createUstensil() {
        return new MexicanUstensil();
    }

    @Override
    public MexicanDish createDish() {
        return new MexicanDish();
    }
}
