package org.example;

import java.util.Scanner;

public class PierrePapierCiseaux {
    public static void Main (){
        Scanner input = new Scanner(System.in);

        int userInt, userPoints, computerInt;
        String computerChoice, userChoice;

        String choicesString = " [1] Pierre\n [2] Papier\n [3] Ciseaux\n";
        do {
            userPoints = 0;

            for (int i = 0;i < 3; i++){
                computerInt = (int)((Math.random() * (4 - 1) + 1));

                System.out.println(choicesString);
                userInt = input.nextInt();

                if (computerInt == 1 ){
                    computerChoice = "Pierre";
                } else if (computerInt == 2) {
                    computerChoice = "Papier";
                } else {
                    computerChoice = "Ciseaux";
                }
                if (userInt == 1 ){
                    userChoice = "Pierre";
                } else if (userInt == 2) {
                    userChoice = "Papier";
                } else {
                    userChoice = "Ciseaux";
                }

                System.out.println("Ordinateur: "+ computerChoice + " | Vous: " + userChoice);

                if (computerInt == userInt) {
                    System.out.println("Egalité, on rejoue la manche!");
                    i--;
                } else if (computerInt > userInt){
                    if (computerInt == 3 && userInt == 1){
                        userPoints ++;
                        System.out.println("Manche gagné!");
                    } else {
                        System.out.println("Perdu!");
                    }
                } else {
                    if (computerInt == 1 && userInt == 3){
                        System.out.println("Perdu!");
                    } else {
                        userPoints ++;
                        System.out.println("Gagné!");
                    }
                }
                if (i == 2) {
                    if (userPoints >= 2) {
                        System.out.println("Vous avez gagné la partie\n");
                    } else {
                        System.out.println("Vous avez perdu la partie\n");
                    }
                }
            }
            System.out.println("Une autre partie?\n[1] oui\n[2] non");
            userInt = input.nextInt();

            if (userInt == 1) continue;
            break;
        } while (true);
    }
}
