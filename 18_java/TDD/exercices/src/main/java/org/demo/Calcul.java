package org.demo;

public class Calcul {
    public double addition(double a, double b) {
        return a + b;
    }

    public double division(double a, double b) throws ArithmeticException {
        if (a == 0 || b == 0) throw new ArithmeticException("Division par zero");
        return a / b;
    }
}
