package org.design_patterns.exercices.tp_02.factory.impl;

import org.design_patterns.exercices.tp_02.entity.AbstractProductBuilder;
import org.design_patterns.exercices.tp_02.entity.Product;
import org.design_patterns.exercices.tp_02.entity.impl.Computer;
import org.design_patterns.exercices.tp_02.factory.ProductFactory;

public class ComputerFactory extends ProductFactory {

    @Override
    public Computer createProduct(AbstractProductBuilder productBuilder) {
        return (Computer) productBuilder.build();

    }
}
