package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        PierrePapierCiseaux.Main();
        JeuDuPendu.Main();
//        CourseVoiture.Main();


//        Scanner input = new Scanner(System.in);
//        // tp festival
//        int maxEndurance = 100;
//        int endurance = maxEndurance;
//        int time = 100;
//        int userInput;
//        StringBuilder userExperience = new StringBuilder();
//
//        do {
//            System.out.println("Bienvenue au festivale de musique virtuelle");
//            System.out.println("sélectionnez votre scène:");
//            System.out.println("[1] Jazz\n[2] Swing\n[3] Metäl\n[4] La buvette");
//
//            double randomEvent = Math.random();
//            if (randomEvent > .75){
//                System.out.println("Boisson énergiseante gratuite! [Energie +20]");
//                endurance += 20;
//                if (endurance > maxEndurance){
//                    endurance = maxEndurance;
//                }
//            }else if (randomEvent > .50) {
//                System.out.println("Les parents rentrent tard! [Temps +10]");
//                time += 10;
//            }
//            System.out.println("Energie : "+endurance+"\nTemps : "+time);
//            userInput = input.nextInt();
//            switch (userInput){
//                case 1:
//                    userExperience.append("[Jazz]");
//                    System.out.println("[1] Mowgli [Energie - 10 | Temps - 20]\n[2] Hugh Laurie [Energie - 15 | Temps - 10]\n");
//                    userInput = input.nextInt();
//                    if( userInput == 1) {
//                        userExperience.append(" Mowgli\n");
//                        endurance -= 10;
//                        time -= 20;
//                    }else {
//                        userExperience.append(" Hugh Laurie\n");
//                        endurance -= 15;
//                        time -= 10;
//                    }
//                    continue;
//                case 2:
//                    userExperience.append("[Swing]");
//                    System.out.println("[1] Caravan Palace [Energie - 30 | Temps - 20]\n[2] Big Bad Voodoo Daddy [Energie - 20 | Temps - 10]\n[3] Speakeasie's [Energie - 25 | Temps - 25]");
//                    userInput = input.nextInt();
//                    if (userInput == 1) {
//                        userExperience.append(" Caravan Palace\n");
//                        endurance -= 30;
//                        time -= 20;
//                    } else if (userInput == 2) {
//                        userExperience.append(" Big Bad Voodoo Daddy\n");
//                        endurance -= 20;
//                        time -= 20;
//                    } else {
//                        userExperience.append(" Speakeasie's\n");
//                        endurance -= 25;
//                        time -= 25;
//                    }
//                    continue;
//                case 3:
//                    userExperience.append("[Metal]");
//                    System.out.println("[1] Rammstein [Energie - 40 | Temps - 15]");
//                    userInput = input.nextInt();
//                    if (userInput == 1) {
//                        userExperience.append(" Rammstein\n");
//                        endurance -= 40;
//                        time -= 15;
//                    }
//                    continue;
//                case 4:
//                    System.out.println("[1] Boisson énergiseante [Energie +20 | Temps - 5]\n[2] Bière [Energie -5 | Temps - 5]");
//                    userInput = input.nextInt();
//                    if(userInput == 1) {
//                        endurance += 20;
//                        if (endurance > maxEndurance){
//                            endurance = maxEndurance;
//                        }
//                    }else {
//                        endurance -= 5;
//                    }
//                    time -= 5;
//            }
//        } while (endurance > 0 && time > 0);
//
//        System.out.println("Merci d'avoir participé à ce festival virtuel");
//        System.out.println("Votre expérience :");
//        System.out.println(userExperience);

//        // exercice 1
//        int randomNbr = (int)(Math.random()*100);
//        System.out.println("Quel est le nombre mystère? (0 - 100)");
//        do {
//            int userTry = input.nextInt();
//
//            if(userTry > randomNbr) {
//                System.out.println("Le nombre mystère est plus petit!");
//            } else if (userTry < randomNbr) {
//                System.out.println("Le nombre mystère est plus grand!");
//            } else {
//                System.out.println("Bien joué! Le nombre mystère était bien " + randomNbr);
//                break;
//            }
//        } while (true);
//
//
//        // exercice 2
//        System.out.println("Sélectionnez le nombre minimal");
//        int userMinNbr = input.nextInt();
//        System.out.println("Sélectionnez le nombre maximal");
//        int userMaxNbr = input.nextInt();
//
//        for (int i = userMinNbr; i <= userMaxNbr; i++) {
//            System.out.println(i);
//        }
//
//        // exercice 3
//        int userPoints = 0;
//        int nbrQuestions = 1;
//        String promptUser;
//        do {
//            System.out.println(userPoints);
//            switch (userPoints){
//                case 0:
//                    System.out.println("Quelle est la capitale du Sri-Lanka");
//                    promptUser = input.nextLine().toLowerCase();
//                    if (promptUser.equals("colombo")) {
//                        userPoints++;
//                        continue;
//                    }
//                    break;
//                case 1:
//                    System.out.println("Qui est l'homme le plus classe du monde");
//                    promptUser = input.nextLine().toLowerCase();
//                    if (promptUser.equals("georges abidbol")) {
//                        userPoints++;
//                        continue;
//                    }
//                    break;
//            }
//            userPoints = 0;
//        }while (userPoints <= nbrQuestions);
//        System.out.println("Bravo!");
//
//        // exercice 4
//        System.out.println("Triangles générator !\nSélectionnez un caractère:");
//        String userChar = input.nextLine();
//        System.out.println("Triangles générator !\nSélectionnez un nombre:");
//        int userNumber = input.nextInt();
//
//
//        for (int i = 1; i < userNumber+1; i++) {
//            String line = "";
//            String spacing = " ";
//            for (int j = 0; j < i; j++) {
//                if (j > 0) {
//                    line += (userChar + userChar);
//                } else {
//                    line += userChar;
//                }
//            }
//            for (int k = i; k < userNumber + 1; k++) {
//                spacing += " ";
//            }
//            System.out.println(spacing + line);
//        }
    }
}