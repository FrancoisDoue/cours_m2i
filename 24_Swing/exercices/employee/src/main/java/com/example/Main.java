package com.example;

import com.example.view.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setTitle("Employee Management");
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}