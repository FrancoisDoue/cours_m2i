package com.example.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FlowLayoutDemo {

    private JPanel panel;
    private JLabel label;
    private JComboBox<String> comboBox;

    public FlowLayoutDemo() {
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        JButton button = new JButton("Button 1");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(e -> System.out.println("Rholala!"));
        panel.add(button);
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));
        JTextField textField = new JTextField(50);
        panel.add(textField);

        comboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
        panel.add(comboBox);
        label = new JLabel("Résultats et sélections s'afficheront ici");
        panel.add(label);
        JButton validateBtn = new JButton("Validate");
        validateBtn.addActionListener(e -> {
            String selection = (String) comboBox.getSelectedItem();
            String textFieldRes =  textField.getText();
            label.setText("Input data : " + textFieldRes + " | Selected : " + selection);

        });
        panel.add(validateBtn);
    }

    public JPanel getPanel() {
        return panel;
    }
}
