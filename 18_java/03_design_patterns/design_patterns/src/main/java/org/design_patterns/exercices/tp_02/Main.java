package org.design_patterns.exercices.tp_02;

import org.design_patterns.exercices.tp_02.entity.Product;
import org.design_patterns.exercices.tp_02.entity.impl.Bike;
import org.design_patterns.exercices.tp_02.entity.impl.Computer;
import org.design_patterns.exercices.tp_02.factory.impl.BikeFactory;
import org.design_patterns.exercices.tp_02.factory.impl.ComputerFactory;

public class Main {
    public static void main(String[] args) {
////
//        Product bike1 = new BikeFactory().createProduct(
//                new Bike.BikeBuilder()
//                        .color("Red")
//                        .isChildSize(true)
//                        .price(100.)
//        );
////
//        Product computer1 = new ComputerFactory().createProduct(
//                new Computer.ComputerBuilder()
//                        .cpuRef("Super processeur 01")
//                        .gpuRef("Super carte graphique 01")
//                        .ram(16)
//                        .pw(700)
//                        .price(750)
//        );
////
//        Product bike2 = new BikeFactory().createProduct(
//                new Bike.BikeBuilder()
//                        .wheelType("Large")
//                        .price(149.99)
//        );
////
//        System.out.println("bike1 = " + bike1);
//        System.out.println("computer1 = " + computer1);
//        System.out.println("bike2 = " + bike2);

        IHM.mainMenu();
    }
}
