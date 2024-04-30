package org.design_patterns.exercices.exo_03_observers;

public interface Observer<T> {
    default void update(T p) {
        System.out.println("from "+ getClass().getSimpleName() + " - for => " + p);
    }
}
