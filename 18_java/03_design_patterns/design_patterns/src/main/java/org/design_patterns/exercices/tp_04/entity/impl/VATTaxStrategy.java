package org.design_patterns.exercices.tp_04.entity.impl;

import org.design_patterns.exercices.tp_04.entity.TaxStrategy;

public class VATTaxStrategy implements TaxStrategy {

    private final double value;

    public VATTaxStrategy(double value) {
        this.value = value;
    }

    @Override
    public double calculateTax(double income) {
        return income * value;
    }

}
