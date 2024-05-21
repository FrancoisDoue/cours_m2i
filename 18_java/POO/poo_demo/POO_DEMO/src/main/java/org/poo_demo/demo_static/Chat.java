package org.poo_demo.demo_static;

public class Chat {
    private String nom;
    private int age;
    private String race;

    public static final String espece = "Felis Catus";
    public static int nbChat = 0;

    public Chat() {
        this("Tigrou", 5, "Tigre");
    }

    public Chat(String nom, int age, String race) {
        this.nom = nom;
        this.age = age;
        this.race = race;
        nbChat++;
    }
    public String getEspece() {
        return espece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
