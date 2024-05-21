package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //exercice 1
//        System.out.println("Vous arrivez au sommet d'une colline, à gauche se trouve un chemin brumeux vers des grottes. A droite, une route pavée menant à la capitale.");
//        System.out.println("[1] à gauche!\n[2] à droite, bien sûr\n[3] Attendre");
//        int choice = input.nextInt();
//        switch (choice) {
//            case 1:
//                System.out.println("Vous vous enfoncez dans les grottes. Plus personne n'entendit parler de vous. (Etonnant!)");
//                break;
//            case 2:
//                System.out.println("Une fois à la capitale, vous abandonnez votre vie d'aventurier pour une carrière d'expert comptable.");
//                break;
//            case 3:
//                System.out.println("Au bout de 100 ans à attendre, vous trouvez enfin la paix intérieure et pouvez enfin devenir un maître du Kung Fu");
//                break;
//            default:
//                System.out.println("Vous vous faites agresser par un MJ en colère.");
//                break;
//        }

        // exercice 2
        System.out.println("Est-ce que l'animal auquel vous pensez vole?\n [oui]\n [non]");
        String response = input.nextLine();

        if (response.equals("oui")) {
            System.out.println("Est-ce qu'il a des plumes?\n [oui]\n [non]");
            String response2 = input.nextLine();

            if (response2.equals("oui")) {
                System.out.println("C'est un oiseau!");
            } else {
                System.out.println("C'est une chauve-souris!");
            }
        } else {
            System.out.println("Est-ce qu'il pond des oeufs?\n [oui]\n [non]");
            String response3 = input.nextLine();

            if (response3.equals("oui")) {
                System.out.println("C'est un serpent!");
            } else {
                System.out.println("C'est une vache.");
            }
        }
        // exercice 3
//        System.out.println("Quel super-héros vous correspond");
//        System.out.println("Pour vous est la plus grande qualité d'un super-héros ?\n[1] La force\n[2] L'intelligence\n[3] La vitesse");
//        int heroChoice = input.nextInt();
//        switch (heroChoice){
//            case 1:
//                System.out.println("Hulk \nIl est fort. Et vert, aussi.");
//                break;
//            case 2:
//                System.out.println("Batman \nIl est Intelligent. Et riche.");
//                break;
//            case 3:
//                System.out.println("Flash \nIl est rapide mais pas très intelligent");
//                break;
//            default:
//                System.out.println("Dans le doute, Superman. ");
//                break;
//        }

        // exercice 4
//        System.out.println("Quelle est votre humeur de la journée en un mot? (joyeux, triste, aventurier, etc.)");
//        String moodChoice = input.nextLine().toLowerCase();
//
//        switch (moodChoice){
//            case "joyeux":
//                System.out.println("Faites une promenade dans les bois en chantonnant");
//                break;
//            case "triste":
//                System.out.println("Prenez le train et regardez par le hublot avec un air mélancolique.");
//                break;
//            case "aventurier":
//                System.out.println("Paré pour prendre le métro à 8h du mat'?");
//                break;
//            default:
//                System.out.println("Le développeur était à court d'idées");
//                break;
//        }
    }
}