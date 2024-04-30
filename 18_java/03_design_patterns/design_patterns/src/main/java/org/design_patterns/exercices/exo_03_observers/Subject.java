package org.design_patterns.exercices.exo_03_observers;


public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
