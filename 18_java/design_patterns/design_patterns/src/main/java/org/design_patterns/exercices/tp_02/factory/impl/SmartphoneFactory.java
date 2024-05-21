package org.design_patterns.exercices.tp_02.factory.impl;

import org.design_patterns.exercices.tp_02.entity.AbstractProductBuilder;
import org.design_patterns.exercices.tp_02.entity.impl.Smartphone;
import org.design_patterns.exercices.tp_02.factory.ProductFactory;

public class SmartphoneFactory extends ProductFactory {

    @Override
    public Smartphone createProduct(AbstractProductBuilder productBuilder) {
        return (Smartphone) productBuilder.build();
    }
}
