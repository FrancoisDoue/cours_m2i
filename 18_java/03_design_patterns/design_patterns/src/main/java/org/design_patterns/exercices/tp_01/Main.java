package org.design_patterns.exercices.tp_01;

import org.design_patterns.exercices.tp_01.entity.Building;
import org.design_patterns.exercices.tp_01.entity.Castle;
import org.design_patterns.exercices.tp_01.factory.CastleFactory;

public class Main {
    public static void main(String[] args) {

        Building castle = new CastleFactory().createBuilding(new Castle.CastleBuilder()
                .size(20)
                .level(1)
                .name("Bochato")
                .style("par défaut")
        );

        System.out.println("castle = " + castle);
    }
}
