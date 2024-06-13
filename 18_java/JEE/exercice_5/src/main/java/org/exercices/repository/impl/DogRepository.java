package org.exercices.repository.impl;

import org.exercices.entity.Dog;
import org.exercices.repository.AbstractRepository;
import org.hibernate.Session;

import java.util.List;

public class DogRepository extends AbstractRepository<Dog> {
    public DogRepository(Session session) {
        super(session);
    }

    @Override
    public Dog find(int id) {
        return session.get(Dog.class, id);
    }

    public List<Dog> findAll() {
        return session.createQuery("from Dog", Dog.class).list();
    }
}
