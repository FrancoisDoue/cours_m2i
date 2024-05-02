package org.design_patterns.exercices.tp_05_global.entity.impl;

import org.design_patterns.exercices.tp_05_global.entity.Car;

public class Tractor extends Car {

    public Tractor(Race race) {
        super(race);
    }

    @Override
    public String toString() {
        return super.toString() + "\uD83D\uDE9C";
    }
}
