package org.poo_exercices.figures.model;

public class Point {

    private double posX;
    private double posY;

    public Point(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public String toString() {
        return "[" + posX + ";" + posY + "]";
    }
}
