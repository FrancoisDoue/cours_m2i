package org.poo_exercices.figures.model;

public abstract class Figure implements IDeplacable {

    protected Point origin;

    public Figure(double x, double y) {
        origin = new Point(x, y);
    }
    public Point getOrigin() {
        return origin;
    }

    @Override
    public void deplacer(double x, double y) {
        origin.setPosX(x);
        origin.setPosY(y);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +": position = " + origin.toString() + ", ";
    }
}
