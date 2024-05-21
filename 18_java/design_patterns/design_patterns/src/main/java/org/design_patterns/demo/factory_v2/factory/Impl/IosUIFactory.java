package org.design_patterns.demo.factory_v2.factory.Impl;

import org.design_patterns.demo.factory_v2.factory.MobileUIFactory;
import org.design_patterns.demo.factory_v2.entity.impl.IOSButton;
import org.design_patterns.demo.factory_v2.entity.impl.IOSToolbar;

public class IosUIFactory extends MobileUIFactory {
    @Override
    public IOSToolbar createToolbar() {
        return new IOSToolbar();
    }

    @Override
    public IOSButton createButton() {
        return new IOSButton();
    }
}
