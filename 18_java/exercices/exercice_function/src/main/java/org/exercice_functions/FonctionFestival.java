package org.exercice_functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FonctionFestival {

    public static int getUserChoice () {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static List prepareFestival () {
        List<String> festivalLabels = new ArrayList<String>();
        festivalLabels.add("Swing");
        festivalLabels.add("Jazz");
        festivalLabels.add("Metal");
        return festivalLabels;
    }

    public static void main(String[] args) {
        int maxEndurance = 100;
        int endurance = maxEndurance;
        int time = 100;
        String[] festivalLabels = {"Swing", "Metal", "Jazz"};


        StringBuilder userExperience = new StringBuilder();
//        do {
//
//        } while (endurance > 0 && time > 0);
    }
}
