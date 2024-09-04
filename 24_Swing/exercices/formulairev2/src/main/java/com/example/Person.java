package com.example;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String email;
    private boolean gender;

    private static List<Person> persons = new ArrayList<>();

    public Person(String name, String email, Boolean gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public static List<Person> getPersons() {
        return persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
