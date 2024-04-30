package org.design_patterns.exercices.tp_03.entity.impl;

import org.design_patterns.exercices.tp_03.entity.Observer;
import org.design_patterns.exercices.tp_03.entity.Subject;

import java.util.ArrayList;
import java.util.Random;

public class Share implements Subject<Share> {
    private final ArrayList<Observer<Share>> observers;
    String name;
    double initialValue;

    private static final Random rdm = new Random();

    public Share(String name, double initialValue) {
        observers = new ArrayList<>();
        this.name = name;
        this.initialValue = initialValue;
    }

    public void updateValue() {
        this.initialValue += rdm.nextDouble(-10,10);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer<Share> o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer<Share> o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    @Override
    public String toString() {
        return "Share{" +
                "name='" + name + '\'' +
                ", initialValue=" + initialValue +
                '}';
    }
}
