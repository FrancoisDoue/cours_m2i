package org.design_patterns.exercices.tp_01;

import org.design_patterns.exercices.tp_01.entity.Building;
import org.design_patterns.exercices.tp_01.entity.Character;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private final List<Building> buildings = new ArrayList<>();
    private final List<Character> characters = new ArrayList<>();

    public void addBuilding (Building building) {
        buildings.add(building);
        checkUnlockable();
    }

    private void addCharacter (Character character) {
        characters.add(character);
        checkUnlockable();
    }

    private void checkUnlockable() {

    }

//    private void unlockCharacter (String characterType) {
//
//    }
}
