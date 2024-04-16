package org.poo_exercices.papeterie.model;

public class Facture {

    private final int idFacture;
    private int maxLignes;
    private Article[] lignes = new Article[0];


    private static int nbFacture = 0;

    public Facture(int maxLignes) {
        idFacture = ++nbFacture;
        this.maxLignes = maxLignes;
    }

    public Facture() {
        this(10);
    }

    public int getIdFacture() {
        return idFacture;
    }

    public boolean addLigne(Article ligne) {
        if (lignes.length +1 > maxLignes) return false;
        this.lignes = new Article[this.lignes.length+1];
        this.lignes[this.lignes.length-1] = ligne;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("facture n° ").append(idFacture).append("\n");
        for (Article article : lignes) str.append(article.toString()).append("\n");
        str.append("\n");
        return str.toString();
    }
}
