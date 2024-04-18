package org.poo_exercices.papeterie.model;

public class Facture {

    private final int idFacture;
    private int maxLignes;
    private String client;

    private Article[] lignes = new Article[0];

    private static int nbFacture = 0;

    public Facture(String client, int maxLignes) {
        idFacture = ++nbFacture;
        this.maxLignes = maxLignes;
        this.client = client;
    }

    public Facture(String client) {
        this(client, 10);
    }

    public boolean addLigne(Article ligne) {
        // si l'ajout dépasserait le max, fin
        if (lignes.length +1 > maxLignes) return false;
        Article[] tempArray = this.lignes;
        // écraser le tableau, nouveau tableau avec pour max la taille du tableau précédent +1
        this.lignes = new Article[this.lignes.length + 1];
        System.arraycopy(tempArray, 0, this.lignes, 0, tempArray.length);
        // System.arraycopy équivalent de :
//        for (int i = 0; i < tempArray.length; i++) {
//            this.lignes[i] = tempArray[i];
//        }
        this.lignes[this.lignes.length-1] = ligne;
        return true;
    }

    @Override
    public String toString() {
        double total = 0;
        StringBuilder str = new StringBuilder();
        str.append("facture n° ").append(idFacture).append("\n");
        str.append("Client: ").append(client).append("\n");
        for (Article article : lignes){
            total += article.getPrix();
            str.append(article).append("\n");
        }
        return str + "Total : " + total + "€\n";
    }
}
