package org.example;

import java.util.Scanner;

public class CourseVoiture {
    public static void Main() {
        Scanner input = new Scanner(System.in);

        int userDistance = 0;
        int computerDistance = 0;
        int userDiceResult, computerDiceResult;

        do {
            userDiceResult = (int)((Math.random() * (7 - 1) + 1));
            computerDiceResult = (int)((Math.random() * (7 - 1) + 1));
            userDistance += userDiceResult;
            computerDistance += computerDiceResult;

            System.out.println("Vous faites un " + userDiceResult + "\nL'ordinateur fait un " + computerDiceResult);
            if (userDistance > computerDistance) {
                System.out.println("Vous avez de l'avance sur votre concurrent");
            } else if (userDistance < computerDistance) {
                System.out.println("Vous êtes à la traine, accélérez!");
            } else {
                System.out.println("Vous êtes au coude à coude!");
            }
            System.out.println("Appuyez sur Entrée pour passer au tour suivant");
            input.nextLine();

        } while (userDistance < 50 || computerDistance < 50);

        if (userDistance > computerDistance) {
            System.out.println("Vous avez gagné!");
        }else {
            System.out.println("Vous avez perdu...");
        }
    }
}
