package org.design_patterns.exercices.exo_07_flyweight.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyWeightFactory {

    private Map<String, SharedVehiclesState> flyweight = new HashMap<>();

    public SharedVehiclesState getFlyweight(String type, String brand, String model, String color) {
        String key = String.join("|", List.of(type, brand, model, color));
        if (!flyweight.containsKey(key))
            flyweight.put(key, new SharedVehiclesState(type, brand, model, color));
        return flyweight.get(key);
    }

}
