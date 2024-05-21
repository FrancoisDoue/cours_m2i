package org.design_patterns.exercices.tp_03.entity;

public interface Subject<T> {
    void registerObserver(Observer<T> tObserver);
    void removeObserver(Observer<T> tObserver);
    void notifyObservers();
}
