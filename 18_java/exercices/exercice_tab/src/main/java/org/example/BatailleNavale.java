package org.example;

import java.util.Scanner;

public class BatailleNavale {
    public static void Main (){

        String[] vPositions = {"a","b","c","d","e","f","g","h","i","j"};
        int[] ships = {5, 4, 3, 3, 2};
        int[][][] ocean = new int[2][10][10];
        int totalPoints = 17;
        int points = 0, enemyPoints = 0;
        // ships placement
        for (int[][] sea : ocean){
            for (int ship : ships){
                boolean isHorizontal = Math.random() > .5 ;
                int randomLine = (int)(Math.random()*(sea.length - ship));
                int randomCol = (int)(Math.random()*(sea.length - ship));
                // SCAN POSITIONS
                for (int i = 0; i < sea.length; i++) {
                    int box = (isHorizontal) ? sea[randomLine][i] : sea[i][randomCol];
                    if (box == 1 ){
                        if(isHorizontal) {
                            randomLine += ship;
                            if(randomLine > sea.length -1) {
                                randomLine = (int)(Math.random()*(sea.length - ship));
                            }
                        } else {
                            randomCol += ship;
                            if(randomCol > sea.length -1) {
                                randomCol = (int)(Math.random()*(sea.length - ship));
                            }
                        }
                        i--;
                    }
                }
                // END SCAN POSITIONS
                for (int i = 0; i < ship; i++) {
                    if (isHorizontal) {
                        sea[randomLine][randomCol+i] = 1;
                    } else {
                        sea[randomLine+i][randomCol] = 1;
                    }
                }
            }
        }

        do{
            // DISPLAY
            String[] boxColors= {" \u001B[34m■ \u001B[0m", " \u001B[34m■ \u001B[0m", " \u001B[0m■\u001B[0m ", " \u001B[31m■ \u001B[0m"};
            int x, y;
            int cnt = 0;
            Scanner input = new Scanner(System.in);
            String userInput;
            // DISPLAY
            for (int[][] seas : ocean){
                cnt++;
                if (cnt > 1) {
                    boxColors[1] = " \u001B[32m■ \u001B[0m";
                }
                for(int i = seas.length-1; i >= 0; i--){
                    StringBuilder displayLine = new StringBuilder(vPositions[i]+" ");
                    for (int box : seas[i]) {
                        displayLine.append(boxColors[box]);
                    }
                    System.out.println(displayLine);
                }
                System.out.println("   0  1  2  3  4  5  6  7  8  9");
            }
            // END DISPLAY
            // USER ACTION
            System.out.println("Sélectionnez coordonnées [ex: a5]");
            userInput = input.nextLine();
            System.out.println("Salve tirée vers " + userInput);
            char[] charArray = userInput.toCharArray();
            for (x = 0; x < vPositions.length; x++) {
                if(vPositions[x].charAt(0) == charArray[0]) break;
            }
            y = charArray[1] - '0'; // char on int cast
            x = (x < vPositions.length) ? x : vPositions.length - 1;
            y = (y < vPositions.length) ? y : vPositions.length - 1;
            if( ocean[0][x][y] == 1 ){
                System.out.println("\u001B[32mTouché!\u001B[0m");
                ocean[0][x][y] = 3;
                points ++;
            } else {
                if (ocean[0][x][y] == 3) {
                    System.out.println("Inutile de s'acharner!");
                }else {
                    System.out.println("Raté!");
                    ocean[0][x][y] = 2;
                }
            }
            // END USER ACTION
            // ENEMY ACTION
            x = (int)(Math.random()*(vPositions.length -1));
            y = (int)(Math.random()*(vPositions.length -1));
            System.out.println("L'adversaire tire en direction de "+vPositions[x]+y);
            if( ocean[1][x][y] == 1 ){
                System.out.println("\u001B[31mVous êtes touché!\u001B[0m");
                ocean[1][x][y] = 3;
                enemyPoints ++;
            } else {
                if (ocean[1][x][y] == 3) {
                    System.out.println("L'adversaire s'acharne...");
                }else {
                    System.out.println("L'adversaire a raté!");
                    ocean[1][x][y] = 2;
                }
            }
            // END ENEMY ACTION
        } while (points < totalPoints && enemyPoints < totalPoints);

        if (points > enemyPoints){
            System.out.println("\nVous avez gagné");
        } else {
            System.out.println("\nVous avez perdu");
        }
    }
}
