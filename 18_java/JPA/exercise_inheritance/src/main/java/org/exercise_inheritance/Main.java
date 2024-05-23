package org.exercise_inheritance;

import org.exercise_inheritance.entity.impl.ElectronicProduct;
import org.exercise_inheritance.entity.impl.FoodProduct;
import org.exercise_inheritance.entity.impl.HousingProduct;
import org.exercise_inheritance.repository.impl.ElectronicProductRepository;
import org.exercise_inheritance.repository.impl.FoodProductRepository;
import org.exercise_inheritance.repository.impl.HousingProductRepository;
import org.exercise_inheritance.util.DatabaseManager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        DatabaseManager.getInstance().getEm();
        FoodProductRepository foodRepository = new FoodProductRepository();
        HousingProductRepository housingRepository = new HousingProductRepository();
        ElectronicProductRepository electronicRepository = new ElectronicProductRepository();

        electronicRepository.save(
                ElectronicProduct.builder().name("Laptop").price(799.99).batteryDuration(180).build()
        );
        electronicRepository.save(
                ElectronicProduct.builder().name("Smartphone").price(500.).batteryDuration(360).build()
        );
        foodRepository.save(
                FoodProduct.builder().name("Sandwich à la fraise").price(3.99).expirationDate(
                        LocalDate.of(2024, 5, 29)
                ).build()
        );
        housingRepository.save(
                HousingProduct.builder()
                        .name("Jolie serviettes imprimées")
                        .price(29.99)
                        .width(90)
                        .height(160)
                        .depth(1)
                        .build()
        );

        System.out.println("\nfind all from electronicRepository : ");
        electronicRepository.getAll().forEach(System.out::println);

        System.out.println("\nfind all from housingRepository : ");
        housingRepository.getAll().forEach(System.out::println);

        System.out.println("\nfind all from electronicProductRepository : ");
        electronicRepository.getAll().forEach(System.out::println);

        DatabaseManager.close();
    }
}