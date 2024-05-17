package org.tp_recipes.entity;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Ingredient {
    private int id;
    private String name;
    private int quantity;

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
