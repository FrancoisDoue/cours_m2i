package org.design_patterns.exercices.exo_07_flyweight.entity;

public class SharedVehiclesState implements VehicleFlyWeight {
    private String type;
    private String brand;
    private String model;
    private String color;

    public SharedVehiclesState(String type, String brand, String model, String color) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public String displayVehicleInfo(int id, int places) {
        return "#" + id + " " + type + " " + places +" "+ brand + " " + model + " " + color;
    }

}
