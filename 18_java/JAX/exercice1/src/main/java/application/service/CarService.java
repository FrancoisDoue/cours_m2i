package application.service;

import jakarta.enterprise.context.ApplicationScoped;
import application.entity.Car;
import application.repository.impl.CarRepository;
import application.util.HibernateManager;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;

//CDI (Context Dependency Injection)
@ApplicationScoped
//@RequestScoped
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
        car.setBrand(newCar.getBrand());
        car.setYear(newCar.getYear());
        car.setColor(newCar.getColor());
        return carRepository.update(car);
    }

    public Car patchCar(Car car, Car newCar) {
        if (car == null) return null;
        if (newCar.getBrand() != null) car.setBrand(newCar.getBrand());
        if (newCar.getYear() != 0) car.setYear(newCar.getYear());
        if (newCar.getColor() != null) car.setColor(newCar.getColor());
        return carRepository.update(car);
    }
}
