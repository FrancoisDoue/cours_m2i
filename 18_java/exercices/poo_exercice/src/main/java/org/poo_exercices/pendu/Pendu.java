package org.poo_exercices.pendu;

import org.poo_exercices.thermometrev3.RandomWord;

public class Pendu {

    private final String mot = new RandomWord().getWord();
    private String masque;
    private int essais = 10;

    public Pendu() {
        this.masque = mot.replaceAll("(.)", "_");
    }

    public void testChar(String character){
        System.out.println("character = " + character);
        if( !mot.contains(character)){
            essais--;
            return;
        }
        if(masque.contains(character)) return;
        int position = -1;
        while ((position = mot.indexOf(character, position+1)) != -1){
            masque = masque.substring(0, position) +
                    character +
                    masque.substring(position+1);
        }
    }
    public boolean isWin(){
        return mot.equals(masque);
    }

    public String getMasque() {
        return masque;
    }

    public int getEssais() {
        return essais;
    }

}
