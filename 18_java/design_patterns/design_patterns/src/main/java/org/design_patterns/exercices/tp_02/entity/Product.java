package org.design_patterns.exercices.tp_02.entity;

public abstract class Product {
    private static int idCount = 0;
    protected int id;
    protected double price;

    protected Product(AbstractProductBuilder builder) {
        id = ++idCount;
        price = builder.price;
    }

}
