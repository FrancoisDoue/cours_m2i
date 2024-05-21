package org.poo_demo.demo;

public class Chat {
    private String nom;
    private int age;
    private String race;

    public Chat(String nom, int age, String race) {
     this.nom = nom;
     this.age = age;
     this.race = race;
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

    public String toString() {
        return "nom : " + this.nom + " | age : " + this.age + " | race : " + this.race;
    }

    public String meow() {
        return "Le chat miaule.";
    }
}
