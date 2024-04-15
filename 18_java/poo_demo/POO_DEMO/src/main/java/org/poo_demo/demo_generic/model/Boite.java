package org.poo_demo.demo_generic.model;

public class Boite<T> {

    private T contenu;

    public Boite(T contenu) {
        this.contenu = contenu;
    }

    public T getContenu() {
        return contenu;
    }

    public void setContenu(T contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Boite{" +
                "contenu=" + contenu +
                '}';
    }
}
