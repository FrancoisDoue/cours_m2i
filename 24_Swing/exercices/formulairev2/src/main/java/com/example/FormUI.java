package com.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class FormUI {
    private JPanel panel;
    private JPanel formPanel;
    private JPanel tablePanel;
    private JTable table;

    private JPanel buttonPanel;


    private static String[][] tableDatas;

    public FormUI() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(createForm());
        panel.add(createTable());
        panel.add(createButtonPanel());
    }

    public JPanel createForm() {
        JTextField nameField = new JTextField(25);
        JTextField emailField = new JTextField(25);
        JPanel formContentPanel = new JPanel();
        formContentPanel.setLayout(new BoxLayout(formContentPanel, BoxLayout.Y_AXIS));
        formContentPanel.setPreferredSize(new Dimension(400, 200));
        JPanel textInputName = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        textInputName.add(new JLabel("Nom : ", JLabel.LEFT));
        textInputName.add(nameField);
        formContentPanel.add(textInputName);

        JPanel textInputEmail = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        textInputEmail.add(new JLabel("Email : ", JLabel.CENTER));

        textInputEmail.add(emailField);
        formContentPanel.add(textInputEmail);

        JPanel textInputGenders = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        textInputGenders.add(new JLabel("Genre : ", JLabel.LEFT));

        ButtonGroup group = new ButtonGroup();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        male.setSelected(true);
        group.add(male);
        group.add(female);
        textInputGenders.add(male);
        textInputGenders.add(female);

        formContentPanel.add(textInputGenders);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        JButton validateButton = new JButton("Ajouter");
        buttonPanel.add(validateButton);
        formContentPanel.add(buttonPanel);

        validateButton.addActionListener((e) -> {
            if (!(emailField.getText().isBlank() || emailField.getText().isBlank())) {
                System.out.println(Arrays.toString(new Object[]{nameField.getText(), emailField.getText(), male.isSelected(), female.isSelected()}));
                addDatas(new Object[]{nameField.getText(), emailField.getText(), male.isSelected(), female.isSelected()});
            }
        });

        formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createTitledBorder("Formulaire d'ajout"));
        formPanel.add(formContentPanel);

        return formPanel;
    }

    public JPanel createTable() {
        String[] columnNames = {"Nom", "Email", "Genre"};
        table = new JTable(tableDatas, columnNames);
        table.setModel(new DefaultTableModel(columnNames,0));

        tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
        tablePanel.setBorder(BorderFactory.createTitledBorder("Tableau de données"));
        tablePanel.add(new JScrollPane(table));

        return tablePanel;
    }

    public JPanel createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        JButton detailButton = new JButton("Détails");
        detailButton.addActionListener((e) -> {
            int rowSelected = table.getSelectedRow();
            if (rowSelected != -1) {
                System.out.println(table.getSelectedRow());
                createDialog(new String[]{
                        (String) table.getValueAt(rowSelected, 0),
                        (String) table.getValueAt(rowSelected, 1),
                        (String) table.getValueAt(rowSelected, 2)
                });
            }
        });
        buttonPanel.add(detailButton);
        return buttonPanel;
    }

    public void createDialog(String[] content) {
        System.out.println(Arrays.toString(content));
        String[] titles = {"Nom : ", "Email : ", "Genre : "};

        JDialog dialog = new JDialog();
        dialog.setSize(200, 150);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < titles.length; i++) {
            JLabel labelTitle = new JLabel(titles[i]);
            JLabel labelContent = new JLabel(content[i]);
            JPanel panel = new JPanel(new BorderLayout(20,10));
            panel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
            panel.add(labelTitle, BorderLayout.WEST);
            panel.add(labelContent, BorderLayout.EAST);
            contentPanel.add(panel, BorderLayout.CENTER);
            dialog.add(contentPanel);
        }
        dialog.add(contentPanel, BorderLayout.CENTER);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setVisible(true);
//        return dialog;
    }

    public void addDatas(Object[] newRow) {
        System.out.println(Arrays.toString(newRow));
        String[] formatedTableData = new String[]{newRow[0].toString(), newRow[1].toString(), (Boolean)newRow[2] ? "Homme": "Femme"};
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(formatedTableData);
        updateUI();
    }

    public void updateUI () {
        table.revalidate();
        table.repaint();
    }

    public JPanel getPanel() {
        return panel;
    }

}
