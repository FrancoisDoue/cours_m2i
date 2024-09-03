package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainGUI {
    private JPanel mainPanel;
    private JPanel form;
    private JTable tableResult;

    public MainGUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        createForm();
        mainPanel.add(form);
        mainPanel.add(new JTable());
//        tableResult = new JTable();
    }

    private void createForm() {
        form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        JPanel textInputName = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textInputName.add(new JLabel("Nom : ", JLabel.RIGHT));
        textInputName.add(new JTextField("", 25));
        form.add(textInputName);

        JPanel textInputEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textInputEmail.add(new JLabel("Email : ", JLabel.RIGHT));
        textInputEmail.add(new JTextField("", 25));
        form.add(textInputEmail);

        JPanel textInputGenders = new JPanel(new FlowLayout());
        ButtonGroup group = new ButtonGroup();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        group.add(male);
        group.add(female);
        textInputGenders.add(male);
        textInputGenders.add(female);

        form.add(textInputGenders);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
