package org.tp_recipes.IHM;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class AbstractIHM {

    private final Scanner sc = new Scanner(System.in);

    protected int intInput() {
        do {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Saisie invalide");
            }
        } while (true);
    }

    protected int intInput(int limit) {
        do {
            String input = sc.nextLine();
            if (input.matches("^[0-" + limit + "]?$"))
                return Integer.parseInt(input);
            System.out.println("Saisie invalide");
        } while (true);
    }

    protected String stringInput() {
        return sc.nextLine();
    }

    protected String stringInputNotEmpty() {
        do {
            String input = stringInput();
            if (!input.isEmpty())
                return input;
            System.out.println("Saisie invalide");
        } while (true);
    }

    public abstract void start() throws SQLException;
}
