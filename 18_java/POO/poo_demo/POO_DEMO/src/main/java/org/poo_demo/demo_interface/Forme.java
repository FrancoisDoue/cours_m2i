package org.poo_demo.demo_interface;

public abstract class Forme implements Calculable {
    protected String nom;

    public Forme(String nom) {
        this.nom = nom;
    }

//    @Override
//    public double calulerAire() {
//        return 0;
//    }
//
//    @Override
//    public double calulerPerimetre() {
//        return Calculable.super.calulerPerimetre();
//    }
}
