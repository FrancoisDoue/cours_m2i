package org.exercices.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
public class Dog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String breed;
    @Column(columnDefinition = "date not null")
    private LocalDate birthDate;

    public Dog(String name, String breed, LocalDate birthDate) {
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
    }

    public Dog(String name, String breed, String birthDate) throws DateTimeParseException {
        this.name = name;
        this.breed = breed;
        this.birthDate = LocalDate.parse(birthDate);
    }

    public Dog() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setBirthDate(String birthDate) throws DateTimeParseException {
        setBirthDate(LocalDate.parse(birthDate));
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}
