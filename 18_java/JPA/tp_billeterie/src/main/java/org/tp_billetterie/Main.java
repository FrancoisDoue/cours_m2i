package org.tp_billetterie;


import org.tp_billetterie.ihm.MainIHM;
import org.tp_billetterie.util.DataFixtures;
import org.tp_billetterie.util.DatabaseManager;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.getInstance();
//        DataFixtures df = new DataFixtures();
//        df.run();
        new MainIHM().start();
        DatabaseManager.close();
    }
}