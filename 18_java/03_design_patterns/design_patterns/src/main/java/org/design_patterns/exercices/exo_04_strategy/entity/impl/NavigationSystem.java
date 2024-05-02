package org.design_patterns.exercices.exo_04_strategy.entity.impl;

import org.design_patterns.exercices.exo_04_strategy.entity.NavigationStrategy;

public class NavigationSystem {

    private String coords;

    public NavigationSystem(String coords) {
        this.coords = coords;
    }

    public void useNavigation(NavigationStrategy navigationStrategy, String coords) {
        setCoords(coords);
        useNavigation(navigationStrategy);
    }

    public void useNavigation(NavigationStrategy navigationStrategy) {
        navigationStrategy.navigate(coords);
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }
}
