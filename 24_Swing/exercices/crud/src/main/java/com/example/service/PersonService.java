package com.example.service;

import com.example.entity.Person;
import com.example.repository.impl.PersonRepository;

import java.util.List;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService() {
        this.personRepository = new PersonRepository();
    }

    public Person getPersonById(int id) {
        return personRepository.getById(id);
    }

    public Person getPersonById(String stringId) {
        try {
            return personRepository.getById(Integer.parseInt(stringId));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Person savePerson(String name, String phone) {
        return personRepository.save(Person.builder().name(name).phone(phone).build());
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.getAll();
    }

    public boolean deletePersonById(String stringId) {
        Person person = getPersonById(stringId);
        if (person == null) return false;
        personRepository.delete(person);
        return true;
    }
}
