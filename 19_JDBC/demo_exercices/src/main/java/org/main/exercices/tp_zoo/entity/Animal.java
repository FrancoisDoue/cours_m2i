package org.main.exercices.tp_zoo.entity;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Animal {
    private int idAnimal;
    private int age;
    private String name;
    private String specie;
    private String description;
    private String location;
    private List<Meal> meals;

    @Override
    public String toString() {
        StringBuilder mealsString = new StringBuilder();
        if (meals == null || meals.isEmpty()) {
            mealsString.append("\n\tL'animal n'a pas encore été nourri");
        } else {
            meals.forEach(meal -> mealsString.append("\n\t").append(meal.toString()));
        }
        return "Animal - - " +
                "idAnimal=" + idAnimal +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", specie='" + specie + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' + mealsString +
                '\n';
    }
}
