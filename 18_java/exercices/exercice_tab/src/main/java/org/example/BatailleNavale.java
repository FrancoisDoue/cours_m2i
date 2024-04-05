package org.example;

import java.util.Scanner;

public class BatailleNavale {
    public static void Main (){

        String[] abscysse = {"a","b","c","d","e","f","g","h","i","j"};
        int[] ships = {5, 4, 3, 3, 2};
        int[][][] ocean = new int[2][10][10];
        int totalPoints = 17;
        int points = 0, enemyPoints = 0;
        // ships placement
        for (int[][] seas : ocean){
            for (int ship : ships){
                boolean isHorizontal = Math.random() > .5 ;
                int randomLine = (int)(Math.random()*(seas.length - ship));
                int randomCol = (int)(Math.random()*(seas.length - ship));
                // SCAN POSITIONS
                for (int i = 0; i < seas.length; i++) {
                    int box = (isHorizontal) ? seas[randomLine][i] : seas[i][randomCol];
                    if (box == 1 ){
                        if(isHorizontal) {
                            randomLine += ship;
                            if(randomLine > seas.length -1) {
                                randomLine = (int)(Math.random()*(seas.length - ship));
                            }
                        } else {
                            randomCol += ship;
                            if(randomCol > seas.length -1) {
                                randomCol = (int)(Math.random()*(seas.length - ship));
                            }
                        }
                        i--;
                    }
                }
                // END SCAN POSITIONS
                for (int i = 0; i < ship; i++) {
                    if (isHorizontal) {
                        seas[randomLine][randomCol+i] = 1;
                    } else {
                        seas[randomLine+i][randomCol] = 1;
                    }
                }
            }
        }

        do{
            // DISPLAY
            String[] boxColors= {" \u001B[34m■ \u001B[0m", " \u001B[34m■ \u001B[0m", " \u001B[30m■ \u001B[0m", " \u001B[31m■ \u001B[0m"};
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
                    StringBuilder displayLine = new StringBuilder(abscysse[i]+" ");
                    for (int box : seas[i]) {
                        displayLine.append(boxColors[box]);
                    }
                    System.out.println(displayLine);
                }
                System.out.println("   0  1  2  3  4  5  6  7  8  9");
            }
            // END DISPLAY
            // USER ACTION
            System.out.println("Sélectionnez coordonnées [a - j]");
            userInput = input.nextLine();
            for (x = 0; x < abscysse.length; x++) {
                if(userInput.equals(abscysse[x])) break;
            }
            System.out.println("Sélectionnez coordonnées [0 - 9]");
            y = Math.abs(input.nextInt());
            x = (x < abscysse.length) ? x : abscysse.length - 1;
            y = (y < abscysse.length) ? y : abscysse.length - 1;
            System.out.println(abscysse[x]+"-"+y);
            if( ocean[0][x][y] == 1 ){
                System.out.println("Touché!");
                ocean[0][x][y] = 3;
                points ++;
            } else {
                System.out.println("Plouf!");
                ocean[0][x][y] = 2;
            }
            // END USER ACTION
            // ENEMY ACTION
            x = (int)(Math.random()*(abscysse.length -1));
            y = (int)(Math.random()*(abscysse.length -1));
            System.out.println("x = " + x + ", y = " + y);
            if( ocean[1][x][y] == 1 ){
                System.out.println("Vous êtes touché!");
                ocean[1][x][y] = 3;
                enemyPoints ++;
            } else {
                System.out.println("L'ennemi a raté!");
                ocean[1][x][y] = 2;
            }
            // END ENEMY ACTION
        } while (points < totalPoints || enemyPoints < totalPoints);
        if (points > enemyPoints){
            System.out.println("Vous avez gagné");
        } else {
            System.out.println("Vous avez perdu");
        }
    }
}
