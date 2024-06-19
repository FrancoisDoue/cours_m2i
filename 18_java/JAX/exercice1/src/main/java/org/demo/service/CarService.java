package org.demo.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.demo.entity.Car;
import org.demo.repository.impl.CarRepository;
import org.demo.util.HibernateManager;

import java.util.List;

@ApplicationScoped

public class CarService {

    private final CarRepository carRepository;

    public CarService() {
        this.carRepository = new CarRepository(HibernateManager.getFactory());
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car getCarById(int id) {
        return carRepository.find(id);
    }

    public void deleteCarById(int id) {
        carRepository.delete(carRepository.find(id));
    }

    public Car createCar(Car car) {
        return carRepository.create(car);
    }

    public Car updateCar(Car newCar) {
        Car car = getCarById(newCar.getId());
        if (car == null) return null;
        if (newCar.getBrand() != null) car.setBrand(newCar.getBrand());
        if (newCar.getYear() != 0) car.setId(newCar.getId());
        if (newCar.getColor() != null) car.setColor(newCar.getColor());
        return carRepository.update(car);
    }
}
