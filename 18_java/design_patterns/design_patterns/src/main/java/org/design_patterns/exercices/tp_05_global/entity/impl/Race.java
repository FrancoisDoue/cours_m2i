package org.design_patterns.exercices.tp_05_global.entity.impl;

import lombok.Getter;
import org.design_patterns.exercices.tp_05_global.entity.Car;
import org.design_patterns.exercices.tp_05_global.entity.Observer;

import java.util.ArrayList;
import java.util.Comparator;

@Getter
public class Race extends Thread implements Observer<Car> {
    private final ArrayList<Car> carList;
    private static Race INSTANCE;

    private Race() {
        carList = new ArrayList<>();
    }

    public static synchronized Race getInstance() {
        if(INSTANCE == null) INSTANCE = new Race();
        return INSTANCE;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    @Override
    public void run() throws RuntimeException {

        while (true) {
            System.out.println(" - - - - - - - - -");
            carList.forEach(Car::move);
            carList.sort(Comparator.comparing(Car::getDistance).reversed());
            carList.forEach(c -> c.setPosition(carList.indexOf(c)+1));

            try {
                boolean isEnd = carList.stream().anyMatch(c -> c.getDistance() >= 200);
                if(isEnd) {
                    System.out.println("Fin de la course \nVictoire de "+ carList.get(0));
                    break;
                }
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void update(Car car) {
        System.out.println(car);
    }
}
