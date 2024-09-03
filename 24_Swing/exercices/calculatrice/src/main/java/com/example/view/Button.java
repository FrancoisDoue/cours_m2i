package com.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class Button {
    private JButton button;

    public Button(Color color, String text) {
        button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 18));
    }

    public JButton getButton() {
        return button;
    }
}
