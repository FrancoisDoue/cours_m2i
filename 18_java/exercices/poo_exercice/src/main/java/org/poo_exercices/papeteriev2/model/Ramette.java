package org.poo_exercices.papeteriev2.model;

public class Ramette extends ArticleUnitaire {
    protected int grammage;

    public Ramette(String nom, double prixUnitaire, int grammage) {
        super(nom, prixUnitaire);
        this.grammage = grammage;
    }

    public int getGrammage() {
        return grammage;
    }

    @Override
    public double getPrix() {
        return this.prixUnitaire;
    }

    @Override
    public String toString() {
        return "Ramette{" +
                "grammage=" + grammage +
                ", nom='" + nom + '\'' +
                ", prix U=" + prixUnitaire +
                '}';
    }
}
