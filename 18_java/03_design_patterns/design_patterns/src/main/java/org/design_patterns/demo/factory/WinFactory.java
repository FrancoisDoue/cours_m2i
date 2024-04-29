package org.design_patterns.demo.factory;


public class WinFactory extends GuiFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckBox();
    }
}
