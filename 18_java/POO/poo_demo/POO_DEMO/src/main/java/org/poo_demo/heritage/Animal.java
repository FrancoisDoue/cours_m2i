package org.poo_demo.heritage;

public class Animal {

    private int age;
    private static int nbAnimaux = 0;


    public Animal(int age) {
        this.age = age;
        nbAnimaux++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
