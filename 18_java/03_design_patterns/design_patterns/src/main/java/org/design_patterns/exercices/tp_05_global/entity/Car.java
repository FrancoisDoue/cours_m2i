package org.design_patterns.exercices.tp_05_global.entity;


import lombok.Getter;
import lombok.Setter;
import org.design_patterns.exercices.tp_05_global.entity.impl.Race;

import java.util.Random;

public abstract class Car implements Subject<Car> {
    private static int idCnt = 0;

    @Setter
    private Observer<Car> observer;
    protected final int id;

    @Getter
    protected int distance = 0;
    protected int position;

    public Car(Race race) {
        id = ++idCnt;
        addObserver(race);
    }

    public void move() {
        distance += new Random().nextInt(5,10);
    }

    public void setPosition(int position) {
        int tempPosition = this.position;
        this.position = position;
        if (tempPosition != this.position) notifyObservers();
    }

    @Override
    public void addObserver(Observer<Car> observer) {
        this.observer = observer;
    }

    @Override
    public void removeObserver(Observer<Car> observer) {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        observer.update(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"_"+ id + " {" +
                "POSITION = " + position +
                ", distance=" + distance +
                '}';
    }
}
