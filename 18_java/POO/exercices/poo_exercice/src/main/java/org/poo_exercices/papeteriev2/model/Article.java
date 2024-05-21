package org.poo_exercices.papeteriev2.model;

import java.util.UUID;

public abstract class Article {
    private final UUID ref;

    protected Article() {
        this.ref = UUID.randomUUID();
        BDD.getInstance().putArticle(this);
    }

    public UUID getRef() {
        return ref;
    }

    public abstract double getPrix();

    @Override
    public String toString() {
        return ref.toString() + " - ";
    }

}
