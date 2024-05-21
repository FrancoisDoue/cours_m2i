package org.design_patterns.exercices.tp_05_global.entity.impl;

import org.design_patterns.exercices.tp_05_global.entity.Car;

public class Tesla extends Car {
    public Tesla(Race race) {
        super(race);
    }

    @Override
    public String toString() {
        return super.toString()+"\uD83D\uDE97";
    }
}
