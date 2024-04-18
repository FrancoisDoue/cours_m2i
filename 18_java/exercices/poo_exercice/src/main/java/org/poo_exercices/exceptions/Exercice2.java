package org.poo_exercices.exceptions;

import java.util.Scanner;

public class Exercice2 {

    public static int positiveIntScan() throws Exception {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int result;
        try {
           result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
