package org.design_patterns.exercices.tp_me_at_the_zoo.utils;

public interface Subject<T> {
    void registerObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObservers();
}
