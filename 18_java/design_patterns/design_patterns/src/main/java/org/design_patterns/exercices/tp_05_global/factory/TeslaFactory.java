package org.design_patterns.exercices.tp_05_global.factory;

import org.design_patterns.exercices.tp_05_global.entity.impl.Race;
import org.design_patterns.exercices.tp_05_global.entity.impl.Tesla;

public class TeslaFactory extends AbstractCarFactory {

    @Override
    public Tesla createCar() {
        return new Tesla(Race.getInstance());
    }
}
