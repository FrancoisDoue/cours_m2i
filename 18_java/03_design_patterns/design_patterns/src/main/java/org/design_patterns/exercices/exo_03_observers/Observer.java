package org.design_patterns.exercices.exo_03_observers;

import java.util.Observable;

public interface Observer {
    default void update(Product p) {
        System.out.println("from "+ getClass().getSimpleName() + " - for => " + p);
    }
}
