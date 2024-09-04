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
        createTablePanel();
        mainPanel.add(form);

        mainPanel.add(tableResult);
//        tableResult = new JTable();
    }

    private void createForm() {
        form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        JPanel textInputName = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
        textInputName.add(new JLabel("Nom : ", JLabel.LEFT));
        textInputName.add(new JTextField("", 25));
        form.add(textInputName);

        JPanel textInputEmail = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
        textInputEmail.add(new JLabel("Email : ", JLabel.LEFT));
        textInputEmail.add(new JTextField("", 25));
        form.add(textInputEmail);

        JPanel textInputGenders = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
        textInputGenders.add(new JLabel("Email : ", JLabel.LEFT));

        ButtonGroup group = new ButtonGroup();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        group.add(male);
        group.add(female);
        textInputGenders.add(male);
        textInputGenders.add(female);

        form.add(textInputGenders);
    }

    public void createTablePanel() {
        tableResult = new JTable();
        tableResult.setLayout(new BoxLayout(tableResult, BoxLayout.Y_AXIS));
        tableResult.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
