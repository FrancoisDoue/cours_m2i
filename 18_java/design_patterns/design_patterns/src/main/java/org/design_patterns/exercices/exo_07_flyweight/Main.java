package org.design_patterns.exercices.exo_07_flyweight;

import org.design_patterns.exercices.exo_07_flyweight.entity.FlyWeightFactory;
import org.design_patterns.exercices.exo_07_flyweight.entity.Vehicle;

public class Main {
    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        Vehicle voiture = new Vehicle(5, factory.getFlyweight("voiture", "Peugeot", "partner", "blanc"));
        Vehicle utilitaire = new Vehicle(2, factory.getFlyweight("voiture", "Peugeot", "partner", "bleu"));
        Vehicle velo1 = new Vehicle(1, factory.getFlyweight("vélo","vélo", "", "bleu"));
        Vehicle velo2 = new Vehicle(1, factory.getFlyweight("vélo","vélo", "", "rouge"));
        Vehicle velo3 = new Vehicle(1, factory.getFlyweight("vélo","vélo", "", "bleu"));


        System.out.println(voiture.display());
        System.out.println(utilitaire.display());
        System.out.println(velo1.display());
        System.out.println(velo2.display());
        System.out.println(velo3.display());
    }
}
