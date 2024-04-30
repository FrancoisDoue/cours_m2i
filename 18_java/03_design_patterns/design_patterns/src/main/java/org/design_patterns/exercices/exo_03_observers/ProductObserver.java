package org.design_patterns.exercices.exo_03_observers;

public interface ProductObserver {
    default void update(Product p) {
        System.out.println("from "+ getClass().getSimpleName() + " - for => " + p);
    }
}
