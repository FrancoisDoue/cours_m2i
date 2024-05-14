package org.main.exercices.tp_zoo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Animal {
    private int idAnimal;
    private int age;
    private String name;
    private String specie;
    private String description;
    private String location;

    @Override
    public String toString() {
        return "Animal{" +
                "idAnimal=" + idAnimal +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", specie='" + specie + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
