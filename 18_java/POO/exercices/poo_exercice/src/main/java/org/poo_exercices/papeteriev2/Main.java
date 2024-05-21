package org.poo_exercices.papeteriev2;

import org.poo_exercices.papeteriev2.model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        BDD bdd = BDD.getInstance();
        Random rand = new Random();
//        Scanner sc = new Scanner(System.in);
        ArrayList<UUID> ids = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ids.add(new Stylo("Stylo"+i, 2.0, "rouge").getRef());
        }
        for (int i = 0; i < 10; i++) {
            ids.add(new Ramette("Ramette"+i, 20.0, 35).getRef());
        }
        int sizeIds = ids.size();
        for (int i = 0; i < 10; i++) {
            ids.add( new Lot(
                ids.get(rand.nextInt(sizeIds)),
                rand.nextInt(2, 5),
                rand.nextDouble(.1,.5)
            ).getRef() );
        }
        ids.forEach(id->System.out.println(bdd.getArticle(id)));
        System.out.println(bdd.getSize());
//        System.out.println("Récupérer un article : ");
//        String id = sc.nextLine();
//        System.out.println("bdd = " + bdd.getArticle(id));

    }
}
