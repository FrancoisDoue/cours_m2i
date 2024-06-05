package org.exercices.exercice_4;

import java.util.List;

public class SearchCity {

    private final List<String> cities;

    public SearchCity(List<String> cities) {
        this.cities = cities;
    }

    public List<String> search(String city) {
        if (city.equals("*")) return cities;
        if (city.length() < 2) throw new NotFoundException("Not found city");
        return cities.stream().filter(c -> c.toLowerCase().contains(city.toLowerCase())).toList();
    }

}
