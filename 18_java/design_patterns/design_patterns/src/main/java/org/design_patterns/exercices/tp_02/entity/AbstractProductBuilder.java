package org.design_patterns.exercices.tp_02.entity;

public abstract class AbstractProductBuilder {
    protected double price;

    public AbstractProductBuilder price(double price) {
        this.price = price;
        return this;
    }

    public abstract Product build();
}
