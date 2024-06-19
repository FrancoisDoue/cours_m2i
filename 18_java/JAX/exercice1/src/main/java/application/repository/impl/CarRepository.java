package application.repository.impl;

import application.entity.Car;
import application.repository.AbstractRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public class CarRepository extends AbstractRepository<Car> {
    public CarRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Car find(int id) {
        session = sessionFactory.openSession();
        Car car = session.get(Car.class, id);
        session.close();
        return car;
    }

    @Override
    public List<Car> findAll() {
        session = sessionFactory.openSession();
        List<Car> cars = session.createQuery("FROM Car", Car.class).getResultList();
        session.close();
        return cars;
    }
}
