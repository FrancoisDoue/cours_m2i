package org.poo_exercices.papeterie.model;

import java.text.DecimalFormat;

public class Lot extends Article {
    private String articleRef;
    private int qte;
    private double reduction;

    public Lot(String articleRef, int qte, double reduction) {
        super();
        this.articleRef = articleRef;
        this.qte = qte;
        this.reduction = reduction;
    }

    public ArticleUnitaire getArticle() {
        return (ArticleUnitaire) Papeterie.getPapeterie().getArticleByRef(articleRef);
    }

    @Override
    public double getPrix() {
        return qte * getArticle().getPrixUnitaire() * (1-reduction);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Lot de " + qte + " - "
                + getArticle().getNom()
                + " - prix: " + df.format(getPrix()) + "€";
    }


}
