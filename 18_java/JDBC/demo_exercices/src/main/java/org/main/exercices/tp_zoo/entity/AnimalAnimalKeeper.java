package org.main.exercices.tp_zoo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalAnimalKeeper {
    private int id;
    private int idAnimal;
    private int idAnimalKeeper;
}
