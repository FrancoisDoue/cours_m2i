package org.design_patterns.demo.factory_v2.factory.Impl;

import org.design_patterns.demo.factory_v2.entity.MobileButton;
import org.design_patterns.demo.factory_v2.entity.Toolbar;
import org.design_patterns.demo.factory_v2.factory.MobileUIFactory;

public class MobileApplication {

    private Toolbar toolbar;
    private MobileButton button;

    public MobileApplication(MobileUIFactory factory) {
        toolbar = factory.createToolbar();
        button = factory.createButton();
    }

    public void renderApplication() {
        toolbar.renderToolBar();
        button.renderButton();
    }
}
