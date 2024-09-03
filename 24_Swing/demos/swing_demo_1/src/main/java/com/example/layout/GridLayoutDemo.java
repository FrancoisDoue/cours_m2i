package com.example.layout;

import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo {

    private JPanel panel;

    public GridLayoutDemo() {
        panel = new JPanel(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton("button " + i);
            button.addActionListener(e -> {
                System.out.println(((JButton) e.getSource()).getText());
            });
            panel.add(button);
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
