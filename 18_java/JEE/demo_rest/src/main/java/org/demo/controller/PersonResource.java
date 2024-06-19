package org.demo.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.demo.entity.Person;

import java.util.ArrayList;
import java.util.List;

@Path("/persons")
public class PersonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(1, "Georges", "Abitbol", 72));
        persons.add(new Person(2, "Martin", "Martin", 20));
        return persons;
    }

    @GET
    @Path("/single")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson() {
        return new Person(1, "Georges", "Abitbol", 72);
    }
}
