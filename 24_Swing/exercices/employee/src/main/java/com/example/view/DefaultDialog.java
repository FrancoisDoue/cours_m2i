package com.example.view;

import javax.swing.*;
import java.awt.*;

public class DefaultDialog extends JDialog {

    public DefaultDialog(Container content) {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(400, 150));
        setLocationRelativeTo(this.getOwner());
        setContentPane(content);
        pack();
        setModal(true);
    }

}
