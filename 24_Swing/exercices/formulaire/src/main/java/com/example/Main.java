package com.example;

import com.example.gui.MainGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 850);
//        frame.pack();
        frame.add(new MainGUI().getPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}