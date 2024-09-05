package com.example.view;

import com.example.model.Department;
import com.example.repository.DepartmentRepository;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Getter
public class DepartmentForm extends JPanel {

//    private JTextField nameField;
    private JButton addButton;
    private JButton cancelButton;
    private static final DepartmentRepository departmentRepository = new DepartmentRepository();

    private DepartmentForm(List<JTextField> textFieldList) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textFieldList.forEach(this::add);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.WHITE);
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel);
    }

    public static void BuildAndShowAddForm(){
        JTextField nameField = new JTextField(50);
        nameField.setBorder(BorderFactory.createTitledBorder("Name of the department"));
        DepartmentForm form = new DepartmentForm(List.of(nameField));
        JDialog dialog = new DefaultDialog(form);
        form.getCancelButton().addActionListener(e -> dialog.dispose());
        form.getAddButton().addActionListener(e -> {
            System.out.println("on add button clicked");
            departmentRepository.save(Department.builder().name(nameField.getText()).build());
            dialog.dispose();
        });
        dialog.setVisible(true);
    }
}
