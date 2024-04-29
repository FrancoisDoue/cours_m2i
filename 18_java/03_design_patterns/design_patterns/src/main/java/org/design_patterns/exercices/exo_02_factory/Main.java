package org.design_patterns.exercices.exo_02_factory;

import org.design_patterns.exercices.exo_02_factory.italian.ItalianFactory;
import org.design_patterns.exercices.exo_02_factory.mexican.MexicanFactory;

public class Main {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant(new MexicanFactory());
        restaurant.make();
        restaurant.setFactory(new ItalianFactory());
        restaurant.make();

    }
}
