package org.main.exercices.tp_zoo.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Meal {
    private int idMeal;
    private String description;
    private LocalDateTime gaveAt;
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
