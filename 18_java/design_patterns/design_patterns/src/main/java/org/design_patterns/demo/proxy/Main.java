package org.design_patterns.demo.proxy;

public class Main {
    public static void main(String[] args) {
        ProxyInternet proxy = new ProxyInternet();
        try {
            proxy.connect("https://m2iformation.fr");
            proxy.connect("https://www.github.com");
            proxy.connect("www.google.com");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
