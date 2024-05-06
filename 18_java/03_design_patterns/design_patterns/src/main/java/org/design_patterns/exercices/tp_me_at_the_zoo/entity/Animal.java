package org.design_patterns.exercices.tp_me_at_the_zoo.entity;

import lombok.Builder;
import lombok.Data;
import org.design_patterns.exercices.tp_me_at_the_zoo.entity.impl.Behavior;
import org.design_patterns.exercices.tp_me_at_the_zoo.utils.Observer;
import org.design_patterns.exercices.tp_me_at_the_zoo.utils.Subject;

import java.util.ArrayList;
import java.util.List;

//@Builder
@Data
public abstract class Animal implements Subject<Animal> {
    protected String name;
    protected int age;
    protected int size;
    protected List<Observer<Animal>> observers;
    protected List<Behavior> behaviors;

    @Override
    public void registerObserver(Observer<Animal> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Animal> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
