package org.poo_exercices.papeterie;

import org.poo_exercices.papeterie.model.*;

public class Main {
    public static void main(String[] args) {
        Papeterie papeterie = Papeterie.getPapeterie();
        Object[] refs = papeterie.getRefs();
        System.out.println(refs[0]);
        System.out.println("papeterie.getArticleByRef(refs.) = " + papeterie.getArticleByRef("stylo_7"));

        for (int i = 0; i < refs.length; i++) {
            System.out.println(i+1 + ". " + papeterie.getArticleByRef((String) refs[i]));
        }
    }
}
