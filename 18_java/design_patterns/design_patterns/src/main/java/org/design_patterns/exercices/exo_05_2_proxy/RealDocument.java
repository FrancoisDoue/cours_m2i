package org.design_patterns.exercices.exo_05_2_proxy;

import lombok.Getter;

@Getter
public class RealDocument implements Document {
    private String filename;
    private String content;

    public RealDocument(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    @Override
    public void edit(String content) {
        this.content = content;
    }

    @Override
    public String read() {
        return content;
    }
}
