package org.poo_demo.demo_generic;

import org.poo_demo.demo_generic.model.Boite;
import org.poo_demo.heritage.Chat;

public class Main {
    public static void main(String[] args) {
        Boite<String> boite = new Boite<>("Yo.");
        Boite<Integer> boite2 = new Boite<>(42);
        Boite<Chat> boite3 = new Boite<>(new Chat(12, "Chat", "Bernard"));

        System.out.println(boite);
        System.out.println(boite2);

        System.out.println(boite3);
    }
}
