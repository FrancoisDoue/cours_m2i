package org.design_patterns.exercices.tp_01.factory;

import org.design_patterns.exercices.tp_01.entity.AbstractBuildingBuilder;
import org.design_patterns.exercices.tp_01.entity.Building;

public abstract class BuildingFactory {

    public abstract Building createBuilding(AbstractBuildingBuilder abstractBuildingBuilder);
}
