package com.example.layout;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo extends JPanel {

    public BorderLayoutDemo() {
        setLayout(new BorderLayout());
        JButton button1 = new JButton("NORTH");
        JButton button2 = new JButton("EAST");
        JButton button3 = new JButton("WEST");
        JButton button4 = new JButton("SOUTH");
        JButton button5 = new JButton("CENTER");

        button1.setForeground(Color.black);
        button2.setForeground(Color.red);
        button3.setForeground(Color.blue);
        button4.setForeground(Color.green);
        button5.setForeground(Color.magenta);

        add(button1, BorderLayout.NORTH);
        add(button2, BorderLayout.EAST);
        add(button3, BorderLayout.WEST);
        add(button4, BorderLayout.SOUTH);
        add(button5, BorderLayout.CENTER);
    }
}
