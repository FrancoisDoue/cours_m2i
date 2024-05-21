package org.design_patterns.exercices.exo_01_builder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pizza {
    public enum Taille {
        PETITE, MOYENNE, GRANDE
    }
    public enum TypePate {
        CLASSIQUE, FINE, EPAISSE
    }

    private final Taille taille;
    private final TypePate typePate;
    private final List<String> fromage;
    private final List<String> garniture;

    private Pizza(PizzaBuilder builder) {
        this.taille = (builder.taille == null) ? Taille.MOYENNE : builder.taille;
        this.typePate = (builder.typePate == null) ? TypePate.CLASSIQUE : builder.typePate;
        this.fromage = builder.fromage;
        this.garniture = builder.garniture;
    }

    public static class PizzaBuilder {
        private Taille taille;
        private TypePate typePate;
        private final List<String> fromage = new ArrayList<>();
        private final List<String> garniture = new ArrayList<>();

        public PizzaBuilder taille(Taille taille) {
            this.taille = taille;
            return this;
        }

        public PizzaBuilder typePate(TypePate typePate) {
            this.typePate = typePate;
            return this;
        }

        public PizzaBuilder ajouterFromage(String... fromage) {
            this.fromage.addAll(Stream.of(fromage).toList());
            return this;
        }

        public PizzaBuilder ajouterGarniture(String... garniture) {
            this.garniture.addAll(Stream.of(garniture).toList());
            return this;
        }

        public Pizza build() throws RuntimeException {
            Set<String> duplicates = new HashSet<>();
            this.fromage.forEach(f -> {
                if (!duplicates.add(f))
                    throw new RuntimeException("Fromage " + f + " existe déjà");
            });
            this.garniture.forEach(g -> {
                if (!duplicates.add(g))
                    throw new RuntimeException("Garniture " + g + " existe déjà");
            });
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "taille=" + taille +
                ", typePate=" + typePate +
                ", fromage=" + fromage +
                ", garniture=" + garniture +
                '}';
    }
}
