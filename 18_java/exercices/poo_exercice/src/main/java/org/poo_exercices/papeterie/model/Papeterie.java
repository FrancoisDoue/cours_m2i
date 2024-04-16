package org.poo_exercices.papeterie.model;

import java.util.HashMap;

public class Papeterie {
    private static Papeterie INSTANCE;
    private HashMap<String, Article> articles = new HashMap<>();

    private Papeterie() {
        ArticleUnitaire[] tempArticles = {
                new Ramette(20, "Ramette 30.gr", 30),
                new Ramette(35, "Ramette 45.gr", 45),
                new Ramette(18, "Ramette 45.gr", 20),
                new Stylo(2, "Stylo rouge", "Rouge"),
                new Stylo(2.5, "Stylo bleu", "Bleu"),
                new Stylo(1.8, "Stylo noir", "noir"),
                new Stylo(2, "Stylo vert", "vert"),
        };
        Lot[] tempLot = {
                new Lot(tempArticles[0], 5, .10),
                new Lot(tempArticles[0], 10, .20),
                new Lot(tempArticles[1], 5, .10),
                new Lot(tempArticles[1], 10, .20),
                new Lot(tempArticles[2], 5, .10),
                new Lot(tempArticles[2], 10, .20),
                new Lot(tempArticles[3], 5, .20),
                new Lot(tempArticles[4], 5, .20),
                new Lot(tempArticles[5], 5, .20),
                new Lot(tempArticles[6], 5, .20),
        };
        for (ArticleUnitaire article : tempArticles) {
            articles.put(article.getRef(), article);
        }
        for (Lot lot : tempLot) {
            articles.put(lot.getRef(), lot);
        }
    }

    public static Papeterie getPapeterie() {
        if (INSTANCE == null) {
            INSTANCE = new Papeterie();
        }
        return INSTANCE;
    }

    public Article getArticleByRef(String ref) {
        return articles.get(ref);
    }

    public Object[] getRefs() {
        return articles.keySet().toArray();
    }
}

