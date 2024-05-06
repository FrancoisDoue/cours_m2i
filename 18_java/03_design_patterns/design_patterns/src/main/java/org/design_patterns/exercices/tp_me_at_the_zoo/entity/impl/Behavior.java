package org.design_patterns.exercices.tp_me_at_the_zoo.entity.impl;

import lombok.Data;

@Data
public class Behavior {
    protected String name;
    protected String effect;

    public Behavior(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public Behavior(String name) {
        this.name = name;
    }

    public String behaviorEffect(){
        return name + " => " + effect;
    }

}
