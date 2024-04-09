package org.poo_exercices;

public class Joueur {
    private String nom;
    private int niveau = 1;
    private long exp = 0;
    private long nextLevel = 100;

    public Joueur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        System.out.println(this.nom + " change de pseudo : \""+ nom + "\"");
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public long getExp() {
        return exp;
    }
    public void setExp(long exp) {
        this.exp = exp;
    }

    public long getNextLevel() {
        return nextLevel;
    }
    public void setNextLevel(long nextLevel) {
        System.out.println("Prochain niveau dans " + nextLevel + " exp");
        this.nextLevel = nextLevel;
    }

    public void ajoutExp(int exp) {
        setExp(getExp() + exp);
        if (getExp() >= getNextLevel()) {
            setNiveau( getNiveau() + 1);
            setExp(0);
            System.out.println("Level up! (niv. " + this.niveau + ")");
            setNextLevel((long)(getNextLevel() * 1.2));
        }
    }

    public void aLAventureCompagnon(int quete, int exp) {
        System.out.println("Le joueur " + getNom() + " a accompli la quête n°" + quete + " ! (+" + exp +")");
        ajoutExp(exp);
    }
}
