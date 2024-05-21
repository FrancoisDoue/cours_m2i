package org.design_patterns.exercices.tp_me_at_the_zoo.factory;

import org.design_patterns.exercices.tp_me_at_the_zoo.entity.Animal;

public abstract class AnimalFactory {
    protected abstract Animal createAnimal();
}
