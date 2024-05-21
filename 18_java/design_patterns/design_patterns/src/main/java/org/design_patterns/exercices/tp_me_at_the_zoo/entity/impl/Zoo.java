package org.design_patterns.exercices.tp_me_at_the_zoo.entity.impl;

import org.design_patterns.exercices.tp_me_at_the_zoo.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private static Zoo INSTANCE;

    private List<Animal> animals;
    private List<Visitor> visitors;

    private Zoo() {
        animals = new ArrayList<>();
        visitors = new ArrayList<>();
    }

    public static synchronized Zoo getInstance() {
        if (INSTANCE == null) INSTANCE = new Zoo();
        return INSTANCE;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }
}
