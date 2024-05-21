package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
        BatailleNavale.Main();


//        String[][] sieges = new String[10][6];
//        String[] rangee = {"A","B","C","D","E","F","G","H","I","J"};
//        int userFirstInput, userSecondInput;
//
//        for(int i = 0; i < sieges.length; i++){
//            for(int j = 0; j < sieges[i].length; j++) {
//                sieges[i][j] = rangee[i]+(j+1);
//            }
//        }
//
//        do {
//            System.out.println("sélectionnez votre rangée");
//            for (int i = 0; i < rangee.length; i++) {
//                System.out.println("["+(i+1)+"] - "+rangee[i]);
//            }
//            userFirstInput = input.nextInt()-1;
//            System.out.println("Sélectionnez votre siège");
//            for (int i = 0; i < sieges[userFirstInput].length; i++) {
//                System.out.println("["+(i+1)+"] - "+sieges[userFirstInput][i]);
//            }
//            userSecondInput = input.nextInt()-1;
//            if (sieges[userFirstInput][userSecondInput].split("-").length > 1) {
//                System.out.println("Ce siège est réservé\n");
//                continue;
//            }
//            System.out.println("Vous avez sélectionné le siège "+sieges[userFirstInput][userSecondInput]);
//            sieges[userFirstInput][userSecondInput] += " - réservé";
//
//            System.out.println("Voulez vous sélectionner un autre siège \n[1] oui\n[2] non");
//            userFirstInput = input.nextInt();
//            if (userFirstInput == 1) continue;
//            break;
//        } while (true) ;



//        String[] evenGame = {"A","B","D","B","C","E","D","A","E","C"};
//        String[] evenMemory = new String[evenGame.length/2];
//        int firstEntry, secondEntry, index = 0;
//
//        do {
//            System.out.println("Entrez le premier nombre [1 à 10]");
//            // conversion en positif, -1 pour correspondre à l'index
//            firstEntry = Math.abs(input.nextInt())-1;
//            // si plus grand que le tableau, prend la taille maximale du tableau
//            if(firstEntry > evenGame.length-1) firstEntry = evenGame.length-1;
//            System.out.println("Carte "+evenGame[firstEntry]);
//
//            System.out.println("Entrez le second nombre [1 à 10]");
//            secondEntry = Math.abs(input.nextInt())-1;
//            if(secondEntry > evenGame.length-1) secondEntry = evenGame.length-1;
//            System.out.println("Carte "+evenGame[secondEntry]);
//
//            if (firstEntry == secondEntry) {
//                System.out.println("Hé ho!");
//                continue;
//            }
//
//            if (evenGame[firstEntry].equals( evenGame[secondEntry] )){
//                boolean isInMemory = false;
//                for(String card : evenMemory){
//                    isInMemory = evenGame[firstEntry].equals(card);
//                    if(isInMemory){
//                        System.out.println("Vous avez déjà trouvé cette paire\n");
//                        break;
//                    }
//                }
//                if(!isInMemory){
//                    System.out.println("Paire trouvée!\n");
//                    evenMemory[index] = evenGame[firstEntry];
//                    index++;
//                }
//            }
//            System.out.println("______________________\n");
//        }while (index < evenMemory.length);
//        System.out.println("Bravo.");

//        String userInput;
//        String[] stringArray = {"a","c","d","g","3","i","k","9","l","m","n"};
//        do {
//            System.out.println("Entrez un caractère :");
//            userInput = input.nextLine();
//            for (int i = 0; i < stringArray.length; i++){
//                if(userInput.equals(stringArray[i])){
//                    System.out.println("Caractère \""+userInput+"\" à la position " + i);
//                }
//            }
//            System.out.println("Continuer? \n[1] Oui\n[2] Non");
//            userInput = input.nextLine();
//            if (userInput.equals("1")) continue;
//            break;
//        } while (true);
    }
}