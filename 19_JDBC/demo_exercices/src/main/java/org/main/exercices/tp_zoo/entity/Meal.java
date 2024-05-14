package org.main.exercices.tp_zoo.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Meal {
    private int idMeal;
    private String description;
    private Date gaveAt;
    private Animal animal;

    @Override
    public String toString() {
        return "Meal{" +
                "idMeal=" + idMeal +
                ", description='" + description + '\'' +
                ", gaveAt=" + gaveAt +
                ", animal='" + animal.getName() +
                "'}";
    }
}
