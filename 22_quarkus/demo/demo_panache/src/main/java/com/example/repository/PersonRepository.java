package com.example.repository;

import com.example.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public List<Person> findByFirstname(String firstname) {
        return list("firstname", firstname);
    }

    public List<Person> findByFirstnameAndLastname(String firstname, String lastname) {
        return list("firstname = ?1 AND lastname = ?2", firstname, lastname);
    }

    public List<Person> findByFirstnameAndLastnameNamedParams(String firstname, String lastname) {
        return list(
                "firstname = :firstname AND lastname = :lastname",
                Parameters.with("firstname", firstname),
                Parameters.with("lastname", lastname)
        );
    }

    public List<Person> seachByAgeBelow(int age) {
        return list("age <= ?1", age);
    }
    public List<Person> seachByAgeAbove(int age) {
        return list("age >= ?1", age);
    }
    public List<Person> seachByAgeBetween(int age1, int age2) {
        return list("age BETWEEN ?1 AND ?2", age1, age2);
    }

    public List<Person> searchPersonBySuffixLastname(String endLastname) {
        return list("lastname LIKE ?1", "%"+endLastname);
    }

}
