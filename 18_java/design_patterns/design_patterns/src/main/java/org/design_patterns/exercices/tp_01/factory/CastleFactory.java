package org.design_patterns.exercices.tp_01.factory;

import org.design_patterns.exercices.tp_01.entity.AbstractBuildingBuilder;
import org.design_patterns.exercices.tp_01.entity.Building;

public class CastleFactory extends BuildingFactory {

    @Override
    public Building createBuilding(AbstractBuildingBuilder castleBuilder) {
        return castleBuilder.build();
    }
}
