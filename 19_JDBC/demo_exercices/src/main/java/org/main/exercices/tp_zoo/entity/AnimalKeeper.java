package org.main.exercices.tp_zoo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalKeeper {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "AnimalKeeper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
