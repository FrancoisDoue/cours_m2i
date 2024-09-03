package com.example.layout;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo {
    private JPanel panel;

    public GridBagLayoutDemo() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JButton button = new JButton("row: " + row + " col: " + col);
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = row;
                constraints.gridy = col;
                constraints.weightx = 1;
                constraints.weighty = 1;
                constraints.fill = GridBagConstraints.BOTH;
                if(row == 0 && col == 0) {
                    constraints.gridwidth = 2;
                }
                if(row == 1 && col == 1) {
                    constraints.gridwidth = 2;
                }
                panel.add(button, constraints);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
