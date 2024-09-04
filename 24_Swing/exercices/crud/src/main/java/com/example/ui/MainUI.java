package com.example.ui;

import com.example.entity.Person;
import com.example.service.PersonService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainUI {

    private JFrame mainFrame;
    private JDialog defaultModal;

    private final PersonService personService;

    public MainUI() {
        personService = new PersonService();
        createAndShowUI();
    }

    public void createAndShowUI() {
        JButton createButton = new JButton("Insert");
        createButton.addActionListener(e -> createInsertModal());
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> createUpdateModal());
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> createDeleteModal());
        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(e -> showPersonsInfo());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(createButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        mainPanel.add(updateButton, constraints);
        constraints.gridx = 2;
        constraints.gridy = 0;
        mainPanel.add(deleteButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        mainPanel.add(selectButton, constraints);

        mainFrame = new JFrame("Crud");
        mainFrame.setMinimumSize(new Dimension(400, 200));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private void createInsertModal() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        JTextField nameField = new JTextField(25);
        nameField.setBorder(BorderFactory.createTitledBorder("Name"));
        JTextField phoneField = new JTextField(25);
        phoneField.setBorder(BorderFactory.createTitledBorder("Phone"));
        JButton insertButton = new JButton("Insert");
        JButton cancelButton = new JButton("Cancel");
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(insertButton);
        buttonsPanel.add(cancelButton);
        formPanel.add(nameField);
        formPanel.add(phoneField);
        formPanel.add(buttonsPanel);
        insertButton.addActionListener(e -> {
            personService.savePerson(nameField.getText(), phoneField.getText());
            closeModal();
        });
        cancelButton.addActionListener(e -> closeModal());
        buildAndShowModal("Insert", formPanel);
    }

    private void createDeleteModal() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        JTextField idField = new JTextField(25);
        idField.setBorder(BorderFactory.createTitledBorder("ID"));
        JButton deleteButton = new JButton("Delete");
        JButton cancelButton = new JButton("Cancel");
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(cancelButton);

        formPanel.add(idField);
        formPanel.add(buttonsPanel);

        deleteButton.addActionListener(e -> {
            if (personService.deletePersonById(idField.getText()))
                System.out.println("Deleted Person ok");
            closeModal();
        });

        cancelButton.addActionListener(e -> closeModal());
        buildAndShowModal("Delete", formPanel);
    }

    private void createUpdateModal() {
        JPanel globalPanel = new JPanel();
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        JTextField idField = new JTextField(25);
        idField.setBorder(BorderFactory.createTitledBorder("ID"));
        JTextField nameField = new JTextField(25);
        nameField.setBorder(BorderFactory.createTitledBorder("Name"));
        nameField.setEnabled(false);
        JTextField phoneField = new JTextField(25);
        phoneField.setBorder(BorderFactory.createTitledBorder("Phone"));
        phoneField.setEnabled(false);

        formPanel.add(idField);
        formPanel.add(nameField);
        formPanel.add(phoneField);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        JButton searchButton = new JButton("Search");
        JButton updateButton = new JButton("Update");
        updateButton.setEnabled(false);
        JButton cancelButton = new JButton("Cancel");
        buttonsPanel.add(searchButton);
        buttonsPanel.add(updateButton);
        buttonsPanel.add(cancelButton);

        searchButton.addActionListener(e -> {
            Person person = personService.getPersonById(idField.getText());
            if (person == null) return;
            nameField.setText(person.getName());
            nameField.setEnabled(true);
            phoneField.setText(person.getPhone());
            phoneField.setEnabled(true);
            updateButton.setEnabled(true);
        });

        updateButton.addActionListener(e -> {
            Person person = personService.getPersonById(idField.getText());
            if (person == null) return;
            person.setName(nameField.getText());
            person.setPhone(phoneField.getText());
            personService.updatePerson(person);
            closeModal();
        });

        cancelButton.addActionListener(e -> closeModal());
        globalPanel.add(formPanel);
        globalPanel.add(buttonsPanel);

        buildAndShowModal("Update", globalPanel);
    }

    private void showPersonsInfo() {
        String[] titles = {"ID", "Name", "Phone"};
        DefaultTableModel tableModel = new DefaultTableModel(titles, 0);

        JTable table = new JTable(tableModel);
        List<Person> persons = personService.getAllPersons();
        for (Person person : persons) {
            tableModel.addRow(new String[]{String.valueOf(person.getId()), person.getName(), person.getPhone()});
        }

        JOptionPane.showMessageDialog(mainFrame, new JScrollPane(table));
    }

    private void buildAndShowModal(String title, JPanel content) {
        defaultModal = new JDialog(mainFrame, title, true);
        defaultModal.setMinimumSize(new Dimension(400, 200));
        defaultModal.setBackground(Color.WHITE);
        defaultModal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        defaultModal.add(content);
        defaultModal.pack();
        defaultModal.setLocationRelativeTo(mainFrame);
        defaultModal.setVisible(true);
    }

    private void closeModal() {
        if (defaultModal != null) {
            defaultModal.dispose();
            defaultModal = null;
        }
    }


}
