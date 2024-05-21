package org.exercice_functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FonctionFestival {

    public static int getUserChoice(int limit) {
        if (limit > 9) limit = 9;
        Scanner input = new Scanner(System.in);
        String response = "";
        do {
            response = input.nextLine();
            if (response.matches("[0-"+limit+"]")) {
                return Integer.parseInt(response);
            }
            System.out.println("Saisie invalide");
        } while (true);
    }
    public static int getUserChoice() {
        return getUserChoice(3);
    }

    public static int setEndurance(int modifier, int base, int max) {
        base += modifier;
        return Math.min(base, max);
    }

    public static void main(String[] args) {
        int maxEndurance = 100;
        int endurance = maxEndurance;
        int time = 100;
        String[] category = {"[Jazz]", "[Swing]", "[Buvette]"};

        String[] scenes = new String[4];
        StringBuilder userExperience = new StringBuilder();
//        do {
//        System.out.println(getUserChoice());
//
//        } while (endurance > 0 && time > 0);
    }
}
