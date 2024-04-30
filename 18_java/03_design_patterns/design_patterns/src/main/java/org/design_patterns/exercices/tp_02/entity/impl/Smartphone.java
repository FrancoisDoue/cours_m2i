package org.design_patterns.exercices.tp_02.entity.impl;

import org.design_patterns.exercices.tp_02.entity.AbstractProductBuilder;
import org.design_patterns.exercices.tp_02.entity.Product;

public class Smartphone extends Product {
    private final String brand;
    private final String model;
    private final String color;

    protected Smartphone(SmartphoneBuilder builder) {
        super(builder);
        brand = builder.brand;
        model = builder.model;
        color = builder.color;
    }

    public static class SmartphoneBuilder extends AbstractProductBuilder {
        private String brand;
        private String model;
        private String color;

        public SmartphoneBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }
        public SmartphoneBuilder model(String model) {
            this.model = model;
            return this;
        }
        public SmartphoneBuilder color(String color) {
            this.color = color;
            return this;
        }

        @Override
        public Smartphone build() {
            return new Smartphone(this);
        }
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + id +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
