package org.design_patterns.demo.proxy;

public class RealInternet implements Internet {
    @Override
    public void connect(String url) {
        System.out.println("Connected to RealInternet => " + url);
    }
}
