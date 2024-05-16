package org.main.exercices.tp_zoo.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AnimalKeeper {
    private int id;
    private String name;
    private List<Animal> animals;

    @Override
    public String toString() {
        return "AnimalKeeper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
