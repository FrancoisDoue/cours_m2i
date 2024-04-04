package org.example;

import java.util.Scanner;

public class BatailleNavale {
    public static void Main (){
        Scanner input = new Scanner(System.in);



        String[] abscysse = {"a","b","c","d","e","f","g","h","i","j","k","l"};
        String[][] boxStatus= {
                {"empty"," \u001B[34m\u25A0 "},
                {"occupied"," \u001B[32m\u25A0 "},
                {"hit"," \u001B[32m\u25A0 "}
        };
        int ships[] = {5, 4, 3, 3, 2};
        int[][] ocean = new int[12][12];

        // placement dreadnought
        for (int ship : ships){
            boolean isHorizontal = Math.random() > .5 ;
            int randomLine = (int)(Math.random()*(ocean.length - ship));
            int randomCol = (int)(Math.random()*(ocean.length - ship));
            for (int i = 0; i < ship; i++) {
                if (isHorizontal) {
                    ocean[randomLine][randomCol+i] = 1;
                } else {
                    ocean[randomLine+i][randomCol] = 1;
                }
            }
        }

        // display
        for(int i = 0; i < ocean.length; i++){
            StringBuilder displayLine = new StringBuilder(abscysse[i]+" ");
            for (int box : ocean[i]) {
                displayLine.append(boxStatus[box][1]);
            }
            System.out.println(displayLine);
        }
        System.out.println("   0  1  2  3  4  5  6  7  8  9  10 11");
        // end display

        do{
            System.out.println("Sélectionnez coordonnées");
//            int x, y;
//            x = abscysse.indexOf(input.nextLine());
//            System.out.println(x);

            break;
        } while (true);

    }
}
