package org.bdd_exo_1.repository;

import java.util.List;

public abstract class ARepository<T> {
    public abstract T get(int id);
    public abstract List<T> getAll();
    public abstract T create(T t);
    public abstract void update(T t);
    public abstract void delete(int id);
}
