package org.design_patterns.demo.factory_v2.factory.Impl;

import org.design_patterns.demo.factory_v2.factory.MobileUIFactory;
import org.design_patterns.demo.factory_v2.entity.impl.AndroidButton;
import org.design_patterns.demo.factory_v2.entity.impl.AndroidToolbar;

public class AndroidUIFactory extends MobileUIFactory {

    @Override
    public AndroidToolbar createToolbar() {
        return new AndroidToolbar();
    }

    @Override
    public AndroidButton createButton() {
        return new AndroidButton();
    }
}
