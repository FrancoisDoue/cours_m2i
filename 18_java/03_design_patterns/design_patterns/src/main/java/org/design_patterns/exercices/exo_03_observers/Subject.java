package org.design_patterns.exercices.exo_03_observers;


public interface Subject<T> {
    void registerObserver(Observer<T> o);
    void removeObserver(Observer<T> o);
    void notifyObservers(T e);
}
