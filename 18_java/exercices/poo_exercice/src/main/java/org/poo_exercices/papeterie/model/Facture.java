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
        Article[] tempArray = this.lignes;
        this.lignes = new Article[this.lignes.length+1];
        for (int i = 0; i < tempArray.length; i++) {
            this.lignes[i] = tempArray[i];
        }
        this.lignes[this.lignes.length-1] = ligne;
        return true;
    }

    @Override
    public String toString() {
        double total = 0;
        StringBuilder str = new StringBuilder();
        str.append("facture n° ").append(idFacture).append("\n");
        for (Article article : lignes){
            total += article.getPrix();
            str.append(article.toString()).append("\n");
        }
        str.append("Total : " + total + "€\n");
        return str.toString();
    }
}
