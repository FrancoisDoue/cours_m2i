package org.exercise_inheritance;

import org.exercise_inheritance.ihm.ProductIHM;
import org.exercise_inheritance.util.DatabaseManager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ProductIHM.getInstance().start();
        DatabaseManager.close();
    }
}