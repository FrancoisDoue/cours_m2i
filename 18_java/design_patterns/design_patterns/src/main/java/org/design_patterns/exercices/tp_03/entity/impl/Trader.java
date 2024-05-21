package org.design_patterns.exercices.tp_03.entity.impl;


import lombok.Data;
import org.design_patterns.exercices.tp_03.entity.Observer;

@Data
public class Trader implements Observer<Share> {

    private String name;

    public Trader(String name) {
        this.name = name;
    }

    public void subscribeToShare(Share p) {
        p.registerObserver(this);
    }

}
