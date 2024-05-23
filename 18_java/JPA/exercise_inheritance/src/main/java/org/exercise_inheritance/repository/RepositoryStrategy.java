package org.exercise_inheritance.repository;

import org.exercise_inheritance.entity.AbstractProduct;

import java.util.List;

public interface RepositoryStrategy<T> {
    T getById(long id);
    List<T> getAll();
    boolean delete(T t);
}
