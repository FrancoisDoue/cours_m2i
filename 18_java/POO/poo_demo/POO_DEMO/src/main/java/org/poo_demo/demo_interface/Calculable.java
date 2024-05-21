package org.poo_demo.demo_interface;

public interface Calculable {
    public double calulerAire();

    default double calulerPerimetre() {
        return 0;
    }
}
