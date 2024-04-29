package org.design_patterns.exercices.tp_01.entity;

public abstract class AbstractBuildingBuilder {

    protected int level;
    protected int size;

    public abstract Castle.CastleBuilder level(int level);
    public abstract Castle.CastleBuilder size(int size);

    public abstract Building build();
}
