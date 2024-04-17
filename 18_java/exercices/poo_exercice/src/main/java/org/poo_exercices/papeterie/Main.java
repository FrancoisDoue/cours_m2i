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
        
        Facture facture = new Facture();
        System.out.println(
                "Ajouter un article si moins de 10 = "
                + facture.addLigne(papeterie.getArticleByRef("stylo_7"))
        );
        facture.addLigne(papeterie.getArticleByRef((String) refs[1]));
        facture.addLigne(papeterie.getArticleByRef((String) refs[1]));
        facture.addLigne(papeterie.getArticleByRef("ramette_1"));
        facture.addLigne(papeterie.getArticleByRef((String) refs[6]));
        facture.addLigne(papeterie.getArticleByRef((String) refs[6]));
        facture.addLigne(papeterie.getArticleByRef((String) refs[6]));
        facture.addLigne(papeterie.getArticleByRef((String) refs[6]));
        facture.addLigne(papeterie.getArticleByRef((String) refs[6]));
        facture.addLigne(papeterie.getArticleByRef((String) refs[6]));
        System.out.println(
                "ajouter un article si plus de 10 = "
                + (facture.addLigne(papeterie.getArticleByRef((String) refs[6])))
        );
        System.out.println("facture = " + facture);
    }
}
