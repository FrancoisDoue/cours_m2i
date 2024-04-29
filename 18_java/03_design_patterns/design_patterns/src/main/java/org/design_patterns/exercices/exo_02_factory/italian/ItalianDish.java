package org.design_patterns.exercices.exo_02_factory.italian;

import org.design_patterns.exercices.exo_02_factory.abstract_classes.Dish;

public class ItalianDish extends Dish {

    @Override
    public void serve() {
        System.out.println("Vous servez un plat italien");
    }
}
