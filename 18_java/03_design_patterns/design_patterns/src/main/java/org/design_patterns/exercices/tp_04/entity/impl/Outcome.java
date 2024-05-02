package org.design_patterns.exercices.tp_04.entity.impl;

import lombok.Getter;
import org.design_patterns.exercices.tp_04.entity.TaxStrategy;

@Getter
public class Outcome {

    private final double initialValue;
    private double finalValue = 0.0;
    private double outcomeValue = 0.0;

    public Outcome(double initialValue) {
        this.initialValue = initialValue;
    }

    public void useTaxStrategy(TaxStrategy taxStrategy) {
        this.outcomeValue = taxStrategy.calculateTax(initialValue);
        finalValue -= taxStrategy.calculateTax(outcomeValue);
    }

}
