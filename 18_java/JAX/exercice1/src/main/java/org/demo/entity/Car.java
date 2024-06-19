package org.demo.entity;

import java.time.Year;

public class Car {
    private int id;
    private String brand;
    private Year year;
    private String color;

    public Car(int id, String brand, int year, String color) {
        this.id = id;
        this.brand = brand;
        this.year = Year.of(year);
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

    public String getYear() {
        return year.toString();
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
