package org.poo_exercices.thermometrev3;

import java.util.Random;

public class RandomWord {
    private final String[] wordList = {
            "anticonstitutionnellement",
            "rhododendron",
            "biscuit",
            "redondant",
            "quetsche",
    };

    private final String word;

    public RandomWord() {
        word = wordList[new Random().nextInt(wordList.length)];
        System.out.println("word = " + word);
    }

    public String getWord() {
        return word;
    }
}
