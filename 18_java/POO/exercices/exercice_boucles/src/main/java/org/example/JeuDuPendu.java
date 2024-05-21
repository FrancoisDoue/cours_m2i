package org.example;

import java.util.Scanner;

public class JeuDuPendu {
    public static void Main() {
//        Scanner input = new Scanner(System.in);
//        String mysteryWord = "test";
//        String displayResult = "____";
//        String userChar;
//
//
//        for (int tests = 10; tests > 0; tests--){
//            System.out.println("try = " + tests);
//            System.out.println(displayResult);
//
//            System.out.println("Entrez une lettre");
//            userChar = input.nextLine();
//
//            System.out.println("userPurpose = " + userChar);
//            if(mysteryWord.contains(userChar)) {
//                tests ++;
//                displayResult.split(userChar);
//            }
//        }

        boolean[] tab = new boolean[10];

        for(int i = 0; i < tab.length; i++){
            System.out.println("tab = " + tab[i]);
        }
        for(boolean element : tab) {
            System.out.println("element = " + element);
        }
    }
}
