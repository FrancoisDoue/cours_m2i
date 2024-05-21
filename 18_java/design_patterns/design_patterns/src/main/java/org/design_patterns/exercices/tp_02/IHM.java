package org.design_patterns.exercices.tp_02;

import org.design_patterns.exercices.tp_02.factory.impl.BikeFactory;
import org.design_patterns.exercices.tp_02.factory.impl.ComputerFactory;
import org.design_patterns.exercices.tp_02.factory.impl.SmartphoneFactory;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IHM {

    public static ProductManager productManager= new ProductManager(Map.of(
            "Vélo", new BikeFactory(),
            "Ordinateur", new ComputerFactory(),
            "Smartphone", new SmartphoneFactory()
    ));

    public static void mainMenu() {
        StringBuilder categoryList = new StringBuilder().append("Sélectionnez un produit à personnaliser: \n");
        AtomicInteger i = new AtomicInteger(1);
        productManager.getFactories().forEach((k, f) -> categoryList
                .append(i.getAndIncrement())
                .append(". ")
                .append(k).append('\n')
        );
        categoryList.append(" - - - - - - - - - - - - - - \n[0] Quitter");
        System.out.println(categoryList);

    }
}
