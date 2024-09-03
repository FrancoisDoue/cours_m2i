package com.example.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainLayout {
    private JPanel panel;

    private JLabel result;
    private JLabel operation;

    private Double lastNumber;
    private String lastOperande;

    private final List<Button> buttons = new ArrayList<>(List.of(
        new Button(Color.GRAY, "C"),
        new Button(Color.GRAY, "+/-"),
        new Button(Color.GRAY, "/"),
        new Button(Color.ORANGE, "%"),
        new Button(Color.DARK_GRAY, "7"),
        new Button(Color.DARK_GRAY, "8"),
        new Button(Color.DARK_GRAY, "9"),
        new Button(Color.ORANGE, "x"),
        new Button(Color.DARK_GRAY, "4"),
        new Button(Color.DARK_GRAY, "5"),
        new Button(Color.DARK_GRAY, "6"),
        new Button(Color.ORANGE, "-"),
        new Button(Color.DARK_GRAY, "1"),
        new Button(Color.DARK_GRAY, "2"),
        new Button(Color.DARK_GRAY, "3"),
        new Button(Color.ORANGE, "+"),
        new Button(Color.DARK_GRAY, "0"),
        new Button(Color.DARK_GRAY, "."),
        new Button(Color.ORANGE, "=")
    ));

    public MainLayout() {
        operation = new JLabel("0");
        operation.setFont(new Font("Arial", Font.PLAIN, 21));
        operation.setForeground(Color.WHITE);
        result = new JLabel("0");
        result.setFont(new Font("Arial", Font.PLAIN, 40));
        result.setForeground(Color.WHITE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);
        panel.add(operation);
        panel.add(Box.createVerticalStrut(50));
        panel.add(result);

        JPanel inputsPanel = new JPanel(new GridBagLayout());
        int cnt = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 4; col++) {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = col;
                constraints.gridy = row;
                constraints.weightx = 1;
                constraints.weighty = 1;
                constraints.fill = GridBagConstraints.BOTH;
                if (row == 4 && col == 0) {
                    constraints.gridwidth = 2;
                    col++;
                }
                JButton btn = buttons.get(cnt).getButton();
                if (!btn.getText().equals("=")) {
                    if (btn.getText().equals("C")) {
                        btn.addActionListener((e) -> clearOperations());
                    } else {
                        btn.addActionListener((e) -> printToOperation(((JButton) e.getSource()).getText()));
                    }
                }
                inputsPanel.add(buttons.get(cnt).getButton(), constraints);
                cnt ++;
            }
        }
        panel.add(inputsPanel);
    }
    
    private void printToOperation(String text) {
        try {
            double res = Double.parseDouble(operation.getText() + text);
//            if (lastNumber != null && lastOperande != null) {
//                Double number = Double.parseDouble(operation.getText());
//                operation.setText(makeOperation(lastNumber, number, lastOperande).toString());
//                lastNumber = null;
//                lastOperande = null;
//                return;
//            }
            if (operation.getText().equals("0")) {
                operation.setText(text);
            } else {
                operation.setText(operation.getText() + text);
            }

            System.out.println("Result: " + res);
        } catch (NumberFormatException e) {
            lastNumber = Double.parseDouble(operation.getText());
            lastOperande = text;
            System.out.println("Result: " + lastNumber + " op: " + text);
        }
        updateCalculatorScreen();
    }

//    private Double makeOperation(Double a, Double b, String op) {
//        return switch (op) {
//            case "+" -> a + b;
//            case "-" -> a - b;
//            case "/" -> a / b;
//            case "%" -> a % b;
//            case "x" -> a * b;
//            default -> throw new IllegalStateException("Unexpected value: " + op);
//        };
//    }
    
    private void clearOperations() {
        operation.setText("0");
        result.setText("0");
        updateCalculatorScreen();
    }

    private void updateCalculatorScreen() {
        result.revalidate();
        operation.revalidate();
        result.repaint();
        operation.repaint();
    }

    public JPanel getPanel() {
        return panel;
    }

}
