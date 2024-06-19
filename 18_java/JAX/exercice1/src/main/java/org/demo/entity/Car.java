package org.demo.entity;

//import java.time.Year;

public class Car {
    private static int cntCars = 0;

    private int id;
    private String brand;
    private int year;
    private String color;

    public Car() {
        this.id = ++cntCars;
    }

    public Car(String brand, int year, String color) {
        this.id = ++cntCars;
        this.brand = brand;
        this.year = year;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
