package org.poo_exercices.papeteriev2.model;

import java.text.DecimalFormat;
import java.util.UUID;

public class Lot extends Article{

    private UUID articleRef;
    private int qte;
    private double reduction;

    public Lot(UUID articleRef, int qte, double reduction) {
        super();
        this.articleRef = articleRef;
        this.qte = qte;
        this.reduction = reduction;
    }

    public ArticleUnitaire getArticle() {
        return (ArticleUnitaire) BDD.getInstance().getArticle(articleRef);
    }

    @Override
    public double getPrix() {
        return qte * getArticle().getPrix() * (1-reduction);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Lot{" +
                " qte=" + qte + "x "+
                getArticle() +
                "prix: "+ df.format(getPrix()) +
                '}';
    }
}
