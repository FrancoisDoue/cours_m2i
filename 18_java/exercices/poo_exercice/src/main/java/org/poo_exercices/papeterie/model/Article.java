package org.poo_exercices.papeterie.model;

public abstract class Article {
    protected String ref;
    protected static int nbArticle = 0;

    public Article() {
        this.ref = getClass().getSimpleName().toLowerCase()
            + "_" + (++nbArticle);
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "ref. " + ref;
    }
}
