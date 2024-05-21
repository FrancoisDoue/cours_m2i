package org.design_patterns.exercices.exo_04_strategy;

import org.design_patterns.exercices.exo_04_strategy.entity.impl.EconomicStrategy;
import org.design_patterns.exercices.exo_04_strategy.entity.impl.NavigationSystem;
import org.design_patterns.exercices.exo_04_strategy.entity.impl.OffroadStrategy;
import org.design_patterns.exercices.exo_04_strategy.entity.impl.RoadStrategy;

public class Main {

    public static void main(String[] args) {
        NavigationSystem navigationSystem = new NavigationSystem("Coordonnées 1");
        navigationSystem.useNavigation(new RoadStrategy());
        navigationSystem.useNavigation(new OffroadStrategy());
        navigationSystem.useNavigation(new EconomicStrategy(), "Coordonnées 2");
    }

}
