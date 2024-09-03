package com.example;

import com.example.layout.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        SwingUtilities.invokeLater(Main::createAndShowGUI);
        JFrame frame = new JFrame("Rholala");
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(new BorderLayoutDemo());
//        frame.add(new FlowLayoutDemo().getPanel());
//        frame.add(new GridLayoutDemo().getPanel());
        frame.add(new BoxLayoutDemo().getPanel());
//        frame.add(new GridBagLayoutDemo().getPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }

//    private static void createAndShowGUI() {
//        JFrame frame = new JFrame("Hello world!");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 300);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
}