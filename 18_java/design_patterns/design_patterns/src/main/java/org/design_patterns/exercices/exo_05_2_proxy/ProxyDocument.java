package org.design_patterns.exercices.exo_05_2_proxy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProxyDocument implements Document {
    private final RealDocument document;
    private static final List<String> history = new ArrayList<>();

    public ProxyDocument(String filename, String content) {
        document = new RealDocument(filename, content);
        log(filename + " created: \"" + content + '"');
    }

    @Override
    public void edit(String content) {
        log(document.getFilename() + " edit: \"" + content + '"');
        document.edit(content);
    }

    @Override
    public String read() {
        log(document.getFilename() + " read");
        return document.read();
    }

    public static void log(String message){
        DateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        history.add(date.format(new Date()) + " - " + message);
    }

    public String historyToString(){
        return String.join("\n", history);
    }
}
