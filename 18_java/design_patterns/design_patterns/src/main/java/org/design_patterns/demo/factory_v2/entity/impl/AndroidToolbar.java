package org.design_patterns.demo.factory_v2.entity.impl;

import org.design_patterns.demo.factory_v2.entity.Toolbar;

public class AndroidToolbar extends Toolbar {
    @Override
    public void renderToolBar() {
        System.out.println("Android Toolbar");
    }
}
