package org.poo_demo.heritage;

public class Felin extends Animal {

    protected final String espece;

    public Felin(int age, String espece) {
        super(age);
        this.espece = espece;
    }
}
