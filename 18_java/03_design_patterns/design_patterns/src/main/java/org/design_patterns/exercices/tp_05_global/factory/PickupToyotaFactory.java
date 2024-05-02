package org.design_patterns.exercices.tp_05_global.factory;

import org.design_patterns.exercices.tp_05_global.entity.Car;
import org.design_patterns.exercices.tp_05_global.entity.impl.PickupToyota;
import org.design_patterns.exercices.tp_05_global.entity.impl.Race;

public class PickupToyotaFactory extends AbstractCarFactory {

    @Override
    public PickupToyota createCar() {
        return new PickupToyota(Race.getInstance());
    }
}
