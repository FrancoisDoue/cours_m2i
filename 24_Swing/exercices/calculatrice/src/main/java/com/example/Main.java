package com.example;

import com.example.view.MainLayout;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Calculatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 550);
//        frame.setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.add(new MainLayout().getPanel());
        frame.setVisible(true);
    }
}