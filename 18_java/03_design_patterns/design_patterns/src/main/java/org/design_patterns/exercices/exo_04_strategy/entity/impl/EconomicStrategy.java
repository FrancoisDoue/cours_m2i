package org.design_patterns.exercices.exo_04_strategy.entity.impl;

import org.design_patterns.exercices.exo_04_strategy.entity.NavigationStrategy;

public class EconomicStrategy implements NavigationStrategy {
    @Override
    public void navigate(String navigation) {
        System.out.println("EconomicStrategy navigate: " + navigation);
    }
}
