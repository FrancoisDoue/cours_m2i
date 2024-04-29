package org.design_patterns.demo.builder;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder().brand("Marque 1").build();
        Car car2 = new Car.CarBuilder().brand("Marque 2").color("Rouge").build();
        Car car3 = new Car.CarBuilder().model("Supercar").year(2023).build();

        System.out.println("car1 = " + car1);
        System.out.println("car2 = " + car2);
        System.out.println("car3 = " + car3);

    }
}
