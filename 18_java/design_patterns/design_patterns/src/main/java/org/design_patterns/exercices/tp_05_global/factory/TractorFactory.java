package org.design_patterns.exercices.tp_05_global.factory;

import org.design_patterns.exercices.tp_05_global.entity.Car;
import org.design_patterns.exercices.tp_05_global.entity.impl.Race;
import org.design_patterns.exercices.tp_05_global.entity.impl.Tractor;

public class TractorFactory extends AbstractCarFactory {


    @Override
    public Tractor createCar() {
        return new Tractor(Race.getInstance());
    }
}
