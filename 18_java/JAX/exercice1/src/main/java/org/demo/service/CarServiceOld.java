package org.demo.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.demo.entity.Car;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarServiceOld {

    private static List<Car> cars = new ArrayList<>(List.of(
            new Car("Opel", 1998, "Chartreuse"),
            new Car("Tesla", 2022, "Rouge"),
            new Car("Peugeot", 1985, "Grise")
    ));

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }

    public Car updateCar(Car newCar) {
        Car car = getCar(newCar.getId());
        if (car != null) {
            if (newCar.getBrand() != null) car.setBrand(newCar.getBrand());
            if (newCar.getYear() != 0) car.setId(newCar.getId());
            if (newCar.getColor() != null) car.setColor(newCar.getColor());
        }
        return car;
    }

    public void deleteCar(int id) {
        cars.remove(getCar(id));
    }

}
