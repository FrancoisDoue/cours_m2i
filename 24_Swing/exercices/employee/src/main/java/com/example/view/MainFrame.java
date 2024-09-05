package com.example.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel contentPanel;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 600));
        pack();
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
//        contentPanel.setLayout(null);
        contentPanel.add(new ActionPanel(), BorderLayout.SOUTH);

    }

//    public JPanel createActionPanel() {
//        JPanel panel = new JPanel(new FlowLayout());
//        EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);
//        panel.setBackground(Color.LIGHT_GRAY);
//        panel.setBorder(emptyBorder);
//        JButton addButton = new JButton("Add");
////        addButton.setBorder(emptyBorder);
//        JButton editButton = new JButton("Edit");
////        editButton.setBorder(emptyBorder);
//        JButton deleteButton = new JButton("Delete");
////        deleteButton.setBorder(emptyBorder);
//        JButton departmentButton = new JButton("Department");
////        departmentButton.setBorder(emptyBorder);
//
//        panel.add(addButton);
//        addButton.addActionListener(e -> new DefaultDialog());
//        panel.add(editButton);
//        panel.add(deleteButton);
////        panel.add(departmentButton);
//
//        return panel;
//    }
}
