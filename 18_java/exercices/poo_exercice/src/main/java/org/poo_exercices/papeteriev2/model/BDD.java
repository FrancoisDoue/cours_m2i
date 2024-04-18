package org.poo_exercices.papeteriev2.model;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public final class BDD {

    private static BDD INSTANCE;
    private final HashMap<UUID, Article> articles = new HashMap<>();

    private BDD() {};

    public static BDD getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BDD();
        }
        return INSTANCE;
    }

    public void putArticle(Article article) {
        this.articles.put(article.getRef(), article);
    }

    public Article getArticle(UUID ref) {
        return this.articles.get(ref);
    }
    public Article getArticle(String ref) {
        return this.getArticle(UUID.fromString(ref));
    }

    public Set<UUID> getArticleKeys() {
        return this.articles.keySet();
    }

    public void removeArticle(UUID ref) {
        this.articles.remove(ref);
    }

    public void removeArticle(String ref) {
        this.articles.remove(UUID.fromString(ref));
    }

    public int getSize() {
        return this.articles.size();
    }
}
