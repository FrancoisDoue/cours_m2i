package org.design_patterns.exercices.exo_05_1_proxy;

public class RealBook implements Book {
    private final String title;
    private final String content;

    public RealBook(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public void readBook() {
        System.out.println(title + "\n" + content);
    }
}
