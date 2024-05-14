package org.main.demo.demo_redone.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Plant {
    private int idPlant;
    private String name;
    private String color;
    private int age;

    @Override
    public String toString() {
        return "Plant{" +
                "idPlant=" + idPlant +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
