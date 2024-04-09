package org.poo_exercices;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        Chaise chaise1 = new Chaise ();
//        Chaise chaise2 = new Chaise (3, "bambou", "gris", 130.99);
//        Chaise chaise3 = new Chaise (1, "métal", "orange", 76.25);
//        System.out.println(chaise1);
//        System.out.println(chaise2);
//        System.out.println(chaise3);

        Film film1 = new Film("La haine", "Mathieu Kassovitz", LocalDate.of(1995, 5, 31), "Drame");
        Film film2 = new Film("Avatar 2", "James Cameron", LocalDate.of(2022, 12, 14), "Drame");

        System.out.println(film1);
        System.out.println(film2);

        Joueur joueur = new Joueur("xXx_darkSasuke_xXx");
        for (int i = 0; joueur.getNiveau() < 50; i++) {
            joueur.aLAventureCompagnon(i + 1, 10 + i);
        }
        joueur.setNom("Bernard");

    }
}