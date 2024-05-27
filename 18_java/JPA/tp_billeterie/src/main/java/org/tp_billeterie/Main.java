package org.tp_billeterie;


import org.tp_billeterie.ihm.MainIHM;
import org.tp_billeterie.util.DataFixtures;
import org.tp_billeterie.util.DatabaseManager;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.getInstance();
//        DataFixtures df = new DataFixtures();
//        df.run();
        new MainIHM().start();
    }
}