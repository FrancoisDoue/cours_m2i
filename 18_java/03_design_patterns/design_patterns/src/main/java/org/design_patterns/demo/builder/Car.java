package org.design_patterns.demo.builder;

public class Car {
    private String brand;
    private String model;
    private String color;
    private int year;

    private Car(CarBuilder builder) {
        // affectation des attributs
        this.brand = builder.brand;
        this.model = builder.model;
        this.color = builder.color;
        this.year = builder.year;
    }

    public static class CarBuilder {
        private String brand;
        private String model;
        private String color;
        private int year;

        public CarBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder year(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", color=" + color + ", year=" + year + "]";
    }

}
