package org.poo_demo;

import org.poo_demo.demo.Chat;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Chat myCat = new Chat("Le chat.", 5, "Chat de gouttière");
        Chat chat2 = new Chat("Grouchat", 10, "Main Coon");

        System.out.println(myCat.getNom() + " " + chat2.getNom());
        System.out.println(myCat.toString());
        myCat.setNom("Le gros chat.");
        System.out.println(myCat.toString());
        System.out.println(myCat.meow());
    }
}