package com.example.view;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter
public class ActionPanel extends JPanel {

    private final JButton addButton;
    private final JButton editButton;
    private final JButton deleteButton;
    private final JButton switchButton;

    private boolean mode;

    public ActionPanel(Container parent) {
        setLayout(new FlowLayout());
        EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);
        setBackground(Color.LIGHT_GRAY);
        setBorder(emptyBorder);
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        switchButton = new JButton("Department");
        add(addButton);
        add(editButton);
        add(deleteButton);
        setSwitchActionButton();
        add(switchButton);
    }

    public void switchMode() {
        mode = !mode;
    }

    public void setSwitchActionButton() {
        switchButton.addActionListener(e -> {
            if (mode) {
                switchButton.setText( "Department" );
//                JOptionPane.showMessageDialog(getParent(), "test 2 : On mode " + mode);
            } else {
                switchButton.setText( "Employee" );
                addButton.addActionListener(event -> {
                    DepartmentForm.BuildAndShowAddForm();
                });
            }
            switchMode();
        });
    }

}
