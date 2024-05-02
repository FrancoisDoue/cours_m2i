package org.design_patterns.exercices.tp_05_global;

import org.design_patterns.exercices.tp_05_global.entity.impl.Race;
import org.design_patterns.exercices.tp_05_global.factory.*;

public class Main {
    public static void main(String[] args) {

        Race race = Race.getInstance();
        race.addCar(new TeslaFactory().createCar());
        race.addCar(new PickupToyotaFactory().createCar());
        race.addCar(new TractorFactory().createCar());

        Race.getInstance().start();
    }
}
