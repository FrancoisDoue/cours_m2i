package com.example.view;

import com.example.repository.EmployeeRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Array;

public class MainFrame extends JFrame {
    private final JPanel contentPanel;
    private final ActionPanel actionPanel;
    private JComponent displayPanel;
    private final EmployeeRepository employeeRepository;

    public MainFrame() {
        employeeRepository = new EmployeeRepository();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 600));
        pack();
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        actionPanel = new ActionPanel(contentPanel);
        buildAndShowDisplay();
        actionPanel.getSwitchButton().addActionListener(e -> {
            buildAndShowDisplay();
        });
        setContentPane(contentPanel);
        contentPanel.add(actionPanel, BorderLayout.SOUTH);
    }

    public void buildAndShowDisplay() {
        if (displayPanel != null) {
            contentPanel.remove(displayPanel);
            displayPanel = null;
        }
        if (actionPanel.isMode()) {
            System.out.println("On employee table");
            System.out.println("test");
            DefaultTableModel tableModel = new DefaultTableModel(
                    new String[]{"ID", "Firstname", "Lastname", "Role", "Department"},0
            );
            displayPanel = new JTable(tableModel);
            employeeRepository.getAll().forEach(e ->
                    tableModel.addRow(new Object[]{
                        e.getId(), e.getFirstname(), e.getLastname(), e.getRole(), (e.getDepartment() == null ? "" : e.getDepartment())
                    })
            );
        } else {
            System.out.println("On Department table");

            displayPanel = new JPanel();
            displayPanel.add(new JLabel("test"));
        }
        contentPanel.add(new JScrollPane(displayPanel), BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

}
