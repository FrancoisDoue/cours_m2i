package org.design_patterns.exercices.tp_02.entity.impl;

import org.design_patterns.exercices.tp_02.entity.AbstractProductBuilder;
import org.design_patterns.exercices.tp_02.entity.Product;

public class Computer extends Product {

    private final String cpuRef;
    private final String gpuRef;
    private final double ram;
    private final int pw;


    protected Computer(ComputerBuilder builder) {
        super(builder);
        cpuRef = builder.cpuRef;
        gpuRef = builder.gpuRef;
        ram = builder.ram;
        pw = builder.pw;
    }

    public static class ComputerBuilder extends AbstractProductBuilder {

        private String cpuRef;
        private String gpuRef;
        private double ram;
        private int pw;

        public ComputerBuilder cpuRef(String cpuRef) {
            this.cpuRef = cpuRef;
            return this;
        }
        public ComputerBuilder gpuRef(String gpuRef) {
            this.gpuRef = gpuRef;
            return this;
        }
        public ComputerBuilder ram(double ram) {
            this.ram = ram;
            return this;
        }
        public ComputerBuilder pw(int pw) {
            this.pw = pw;
            return this;
        }

        @Override
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", price=" + price +
                ", cpuRef='" + cpuRef + '\'' +
                ", gpuRef='" + gpuRef + '\'' +
                ", ram=" + ram + "G" +
                ", pw=" + pw + "W"+
                '}';
    }
}
