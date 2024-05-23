package org.tp_billeterie;

import org.tp_billeterie.util.DatabaseManager;

public class Main {
    public static void main(String[] args) {

        DatabaseManager.getInstance();
        System.out.println("Hello world!");
    }
}