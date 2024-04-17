package org.poo_exercices.papeterie.model;

import java.text.DecimalFormat;

public class Lot extends Article {
    private ArticleUnitaire articleUnitaire;
    private int qte;
    private double reduction;
    private double total;

    public Lot(ArticleUnitaire articleUnitaire, int qte, double reduction) {
        super();
        this.articleUnitaire = articleUnitaire;
        this.qte = qte;
        this.reduction = reduction;
    }

    public ArticleUnitaire getArticleUnitaire() {
        return articleUnitaire;
    }

    @Override
    public double getPrix() {
        return qte * articleUnitaire.getPrixUnitaire() * (1-reduction);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return qte + " - " + articleUnitaire + " - total: "
                + df.format(getPrix()) + "€";
    }


}
