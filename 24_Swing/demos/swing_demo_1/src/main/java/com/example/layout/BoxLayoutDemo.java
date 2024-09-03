package com.example.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo {
    private JPanel panel;
    private JPanel msgPanel = new JPanel();


    public BoxLayoutDemo() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        msgPanel = new JPanel();
        msgPanel.setLayout(new BoxLayout(msgPanel, BoxLayout.Y_AXIS));

        JButton addButton = new JButton("Ajouter un message");
        addButton.setBackground(Color.ORANGE);
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addButton.setForeground(Color.BLACK);
        addButton.addActionListener(e -> this.addMessage("Hello World"));

        JButton removeButton = new JButton("Supprimer un message");
        removeButton.setBackground(Color.RED);
        removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeButton.setForeground(Color.WHITE);
        removeButton.addActionListener(e -> this.removeLastMessage());

        JButton clearMessageButton = new JButton("Supprimer tous les messages");
        clearMessageButton.setBackground(Color.BLACK);
        clearMessageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearMessageButton.setForeground(Color.WHITE);
        clearMessageButton.addActionListener(e -> {
            msgPanel.removeAll();
            updateUI();
        });

        panel.add(addButton);
        panel.add(removeButton);
        panel.add(clearMessageButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JScrollPane(msgPanel));
    }

    private void addMessage(String msg) {
        msgPanel.add(new JLabel(msg));
        updateUI();
    }

    private void removeLastMessage() {
        msgPanel.remove(msgPanel.getComponentCount() - 1);
        updateUI();
    }

    private void updateUI() {
        msgPanel.revalidate();
        msgPanel.repaint();
    }

    public JPanel getPanel() {
        return panel;
    }
}
