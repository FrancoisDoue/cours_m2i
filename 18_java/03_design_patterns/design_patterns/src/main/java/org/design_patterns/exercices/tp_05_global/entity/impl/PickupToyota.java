package org.design_patterns.exercices.tp_05_global.entity.impl;

import org.design_patterns.exercices.tp_05_global.entity.Car;
import org.design_patterns.exercices.tp_05_global.entity.Observer;

public class PickupToyota extends Car {

    public PickupToyota(Race race) {
        super(race);
    }


    @Override
    public String toString() {
        return super.toString() + "\uD83D\uDE9A";
    }
}
