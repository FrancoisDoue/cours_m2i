package org.exercices.exercice_4;

import java.util.List;

public class SearchCity {

    private final List<String> cities = List.of(
            "Paris",
            "Budapest",
            "Skopje",
            "Rotterdam",
            "Valence",
            "Vancouver",
            "Amsterdam",
            "Vienne",
            "Sydney",
            "New York",
            "Londres",
            "Bangkok",
            "Hong Kong",
            "Dubaï",
            "Rome",
            "Istanbul"
    );

    public List<String> search(String city) {
        if (city.length() < 2) throw new NotFoundException("Not found city");
        return cities.stream().filter(c -> c.toLowerCase().contains(city.toLowerCase())).toList();
    }

    public List<String> getCities() {
        return cities;
    }
}
