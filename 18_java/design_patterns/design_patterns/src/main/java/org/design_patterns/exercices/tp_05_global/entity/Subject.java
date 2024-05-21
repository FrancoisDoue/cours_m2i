package org.design_patterns.exercices.tp_05_global.entity;

public interface Subject<T> {
    void addObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObservers();
}
