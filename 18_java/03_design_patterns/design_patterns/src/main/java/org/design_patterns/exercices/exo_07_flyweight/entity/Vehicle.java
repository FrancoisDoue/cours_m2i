package org.design_patterns.exercices.exo_07_flyweight.entity;

public class Vehicle {
    private static int cntVehicles = 0;
    private final int id;
    private int places;

    private VehicleFlyWeight vehiclesFlyWeight;

    public Vehicle(int places, VehicleFlyWeight vehiclesFlyWeight) {
        this.id = ++cntVehicles;
        this.places = places;
        this.vehiclesFlyWeight = vehiclesFlyWeight;
    }

    public String display() {
        return this.vehiclesFlyWeight.displayVehicleInfo(id, places);
    }
}
