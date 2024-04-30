package org.design_patterns.exercices.tp_02.factory.impl;

import org.design_patterns.exercices.tp_02.entity.AbstractProductBuilder;
import org.design_patterns.exercices.tp_02.entity.impl.Bike;
import org.design_patterns.exercices.tp_02.factory.ProductFactory;

public class BikeFactory extends ProductFactory {
    @Override
    public Bike createProduct(AbstractProductBuilder productBuilder) {
        return (Bike) productBuilder.build();
    }
}
