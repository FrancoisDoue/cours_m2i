package org.exercices.exercice4;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;
import java.util.function.Predicate;

public class SearchCity {

    private List<String> cities = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

    public List<String> search(String city){
        if (city.length() < 2) throw new NotFoundException();
        return cities.stream().filter(c -> c.toLowerCase().startsWith(city.toLowerCase())).toList();
    }
}
