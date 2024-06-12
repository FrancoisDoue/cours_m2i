package org.exercices.repository.impl;

import org.exercices.entity.Dog;
import org.exercices.repository.AbstractRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public class DogRepository extends AbstractRepository<Dog> {
    public DogRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Dog find(int id) {
        session = factory.openSession();
        Dog dog = session.get(Dog.class, id);
        session.close();
        return dog;
    }

    public List<Dog> findAll() {
        session = factory.openSession();
        List<Dog> dogs = session.createQuery("from Dog", Dog.class).list();
        session.close();
        return dogs;
    }
}
