package org.design_patterns.exercices.tp_02.entity.impl;

import org.design_patterns.exercices.tp_02.entity.AbstractProductBuilder;
import org.design_patterns.exercices.tp_02.entity.Product;

public class Bike extends Product {

    private final String color;
    private final String wheelType;
    private final boolean isChildSize;

    private Bike(BikeBuilder builder) {
        super(builder);
        this.color = builder.color;
        this.wheelType = builder.wheelType;
        this.isChildSize = builder.isChildSize;
    }

    public static class BikeBuilder extends AbstractProductBuilder {
        private String color;
        private String wheelType;
        private boolean isChildSize;

        public BikeBuilder color(String color) {
            this.color = color;
            return this;
        }
        public BikeBuilder wheelType(String wheelType) {
            this.wheelType = wheelType;
            return this;
        }
        public BikeBuilder isChildSize(boolean isChildSize) {
            this.isChildSize = isChildSize;
            return this;
        }

        @Override
        public Bike build() {
            return new Bike(this);
        }
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", wheelType='" + wheelType + '\'' +
                ", size=" + (isChildSize ? "Child" : "Adult") +
                '}';
    }
}
