package org.design_patterns.exercices.tp_04.entity.impl;

import org.design_patterns.exercices.tp_04.entity.TaxStrategy;

public class ProgressiveTaxStrategy implements TaxStrategy {

    private final double value;

    public ProgressiveTaxStrategy(double value) {
        this.value = value;
    }
    @Override
    public double calculateTax(double income) {
        return income * value;
    }
}
