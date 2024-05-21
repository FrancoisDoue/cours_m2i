package org.design_patterns.exercices.tp_02.factory;

import org.design_patterns.exercices.tp_02.entity.AbstractProductBuilder;
import org.design_patterns.exercices.tp_02.entity.Product;

public abstract class ProductFactory {

    public abstract Product createProduct(AbstractProductBuilder productBuilder);
}
