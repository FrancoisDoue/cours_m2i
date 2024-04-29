package org.design_patterns.demo.factory;


public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GuiFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
}
