package org.design_patterns.demo.factory_v2.factory;

import org.design_patterns.demo.factory_v2.entity.MobileButton;
import org.design_patterns.demo.factory_v2.entity.Toolbar;

public abstract class MobileUIFactory {

    public abstract Toolbar createToolbar();
    public abstract MobileButton createButton();

}
