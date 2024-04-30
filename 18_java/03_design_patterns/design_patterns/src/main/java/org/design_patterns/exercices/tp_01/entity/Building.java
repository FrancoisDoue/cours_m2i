package org.design_patterns.exercices.tp_01.entity;

public abstract class Building {
    protected int level;
    protected int size;
    protected String style;
    protected String name;

    @Override
    public String toString() {
        return "Building{" +
                "level=" + level +
                ", size=" + size +
                ", style='" + style + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
