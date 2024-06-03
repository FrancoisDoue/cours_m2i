package org.exercices.exercice_4;

import jdk.jshell.spi.ExecutionControl;

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

    public List<String> search(String city) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not yet implemented");
    }

    public List<String> getCities() {
        return cities;
    }
}
