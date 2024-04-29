package org.design_patterns.demo.factory;

public class Main {
    public static void main(String[] args) {

        Application application = new Application(new WinFactory());

    }
}
