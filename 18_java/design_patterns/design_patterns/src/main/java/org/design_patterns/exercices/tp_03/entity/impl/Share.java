package org.design_patterns.exercices.tp_03.entity.impl;

import lombok.Getter;
import org.design_patterns.exercices.tp_03.entity.Observer;
import org.design_patterns.exercices.tp_03.entity.Subject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

@Getter
public class Share implements Subject<Share> {
    private final ArrayList<Observer<Share>> observers;
    private final String name;
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
        observers.forEach(o -> o.updateToString(this));
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Share{" +
                "name='" + name + '\'' +
                ", value=" + df.format(initialValue) + " $" +
                '}';
    }
}
