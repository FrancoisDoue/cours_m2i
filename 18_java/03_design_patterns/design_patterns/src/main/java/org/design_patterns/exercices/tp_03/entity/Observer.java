package org.design_patterns.exercices.tp_03.entity;

public interface Observer<T> {
    default String updateToString(T t) {
        return t.toString();
    }
}
