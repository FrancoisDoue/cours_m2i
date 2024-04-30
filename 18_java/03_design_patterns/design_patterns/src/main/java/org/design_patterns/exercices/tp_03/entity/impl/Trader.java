package org.design_patterns.exercices.tp_03.entity.impl;


import org.design_patterns.exercices.tp_03.entity.Observer;

public class Trader implements Observer<Share> {

    private String name;

    public Trader(String name) {
        this.name = name;
    }

    @Override
    public void update(Share p) {
        System.out.println("Ping => " + p);
    }

    public void subscribeToShare(Share p) {
        p.registerObserver(this);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
