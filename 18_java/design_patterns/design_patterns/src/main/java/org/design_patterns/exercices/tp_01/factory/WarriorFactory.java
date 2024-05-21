package org.design_patterns.exercices.tp_01.factory;

import org.design_patterns.exercices.tp_01.entity.AbstractCharacterBuilder;
import org.design_patterns.exercices.tp_01.entity.Character;

public class WarriorFactory extends CharacterFactory{

    @Override
    public Character createCharacter(AbstractCharacterBuilder builder) {
        return builder.build();
    }
}
