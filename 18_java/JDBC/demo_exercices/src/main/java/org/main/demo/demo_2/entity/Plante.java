package org.main.demo.demo_2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Plante {
    private String name, color;
    private int age, id_plante;

    @Override
    public String toString() {
        return "Plante{" +
                "id_plante=" + id_plante +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
