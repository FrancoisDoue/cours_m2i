package com.example.repository.impl;

import com.example.entity.Person;
import com.example.repository.AbstractRepository;

import java.util.List;

public class PersonRepository extends AbstractRepository<Person> {
    @Override
    public Person getById(int id) {
        return _em.find(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        return _em.createQuery("from Person", Person.class).getResultList();
    }
}
