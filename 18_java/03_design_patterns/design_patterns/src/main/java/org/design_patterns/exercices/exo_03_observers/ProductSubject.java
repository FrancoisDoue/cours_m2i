package org.design_patterns.exercices.exo_03_observers;


public interface ProductSubject {
    void registerObserver(ProductObserver o);
    void removeObserver(ProductObserver o);
    void notifyObservers();
}
