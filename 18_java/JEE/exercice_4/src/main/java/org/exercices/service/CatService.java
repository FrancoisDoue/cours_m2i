package org.exercices.service;

import org.exercices.entity.Cat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CatService {

    private static List<Cat> cats = new ArrayList<>(List.of(
            new Cat("Garfield", "Européen", "Lasagnes", LocalDate.of(1985,1, 1)),
            new Cat("Chaussette", "Siamois", "Tes orteils", LocalDate.of(2018, 5, 1)),
            new Cat("Jean-Eude", "Persan", "Sheba", LocalDate.of(2015, 9,5))
    ));

    public List<Cat> getCats() {
        return cats;
    }

    public void add(String name, String race, String meat, String date) {
        cats.add(new Cat(name, race, meat, LocalDate.parse(date)));
    }
}
