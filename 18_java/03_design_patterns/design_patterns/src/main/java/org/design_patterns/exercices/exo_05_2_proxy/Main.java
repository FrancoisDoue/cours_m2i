package org.design_patterns.exercices.exo_05_2_proxy;

public class Main {
    public static void main(String[] args) {
        ProxyDocument document = new ProxyDocument("document 1", "a");
        String content = document.read();
        document.edit(content += "b");
        ProxyDocument document2 = new ProxyDocument("document 2", "abcd");
        document2.edit("qwerty");
        document.edit(content + "c");
        document.read();

        System.out.println(document.historyToString());
    }
}
