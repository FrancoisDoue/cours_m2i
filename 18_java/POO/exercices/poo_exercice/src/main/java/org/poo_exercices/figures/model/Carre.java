package org.poo_exercices.figures.model;

public class Carre extends Figure {
    private double cote;

    public Carre(double x, double y, double cote) {
        super(x, y);
        this.cote = cote;
    }

    public double getCote() {
        return cote;
    }

    public void setCote(double cote) {
        this.cote = cote;
    }

    @Override
    public String toString() {
        double x = origin.getPosX();
        double y = origin.getPosY();
        return String.format("""
                %s %s
                A : %s
                B : %s
                C : %s
                D : %s
                """,
                super.toString(),
                "Coté : " + cote,
                x + ";" + y,
                x + ";" + (y+cote),
                (x+cote) + ";" + (y+cote),
                (x+cote) + ";" + y );
    }
}
