package org.design_patterns.exercices.tp_01.entity;

public abstract class AbstractCharacterBuilder {

    protected String name;
    protected int strength;
    protected int magic;

    public AbstractCharacterBuilder name(String name) {
        this.name = name;
        return this;
    }
    public AbstractCharacterBuilder strength(int strength) {
        this.strength = strength;
        return this;
    }
    public AbstractCharacterBuilder magic(int magic) {
        this.magic = magic;
        return this;
    }

    public abstract Character build();
}
