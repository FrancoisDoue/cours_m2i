package org.design_patterns.exercices.tp_01.entity;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int magic;

    protected Character(AbstractCharacterBuilder builder) {
        this.name = builder.name;
        this.strength = builder.strength;
        this.magic = builder.magic;
    }
}
