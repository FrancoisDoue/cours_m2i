package org.demo.service;

import org.demo.entity.Car;

import java.util.List;

public class CarService {

    private static List<Car> cars = List.of(
            new Car(1, "Opel", 1998, "Chartreuse"),
            new Car(2, "Tesla", 2022, "Rouge"),
            new Car(3, "Peugeot", 1985, "Grise")
    );

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }
}
