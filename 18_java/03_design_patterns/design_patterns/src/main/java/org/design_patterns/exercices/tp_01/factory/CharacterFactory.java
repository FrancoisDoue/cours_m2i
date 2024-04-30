package org.design_patterns.exercices.tp_01.factory;

import org.design_patterns.exercices.tp_01.entity.AbstractCharacterBuilder;
import org.design_patterns.exercices.tp_01.entity.Character;

public abstract class CharacterFactory {

    public abstract Character createCharacter(AbstractCharacterBuilder abstractCharacterBuilder);
}
