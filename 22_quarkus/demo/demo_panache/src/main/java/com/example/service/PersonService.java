package com.example.service;

import com.example.entity.Person;
import com.example.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepository personRepository;

    public List<Person> findAllPersons() {
        return personRepository.listAll();
    }

    @Transactional
    public Person createPerson(String firstName, String lastName, int age) {
        Person person = Person.builder().firstname(firstName).lastname(lastName).age(age).build();
        personRepository.persist(person);
        return person;
    }

    public Optional<Person> findPersonById(Long id) {
        return personRepository.findByIdOptional(id);
    }

    public List<Person> findPersonByFirstname(String firstName) {
        return personRepository.findByFirstname(firstName);
    }

    @Transactional
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

}
