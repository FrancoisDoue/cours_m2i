package org.design_patterns.demo.factory_v2.entity.impl;


import org.design_patterns.demo.factory_v2.entity.MobileButton;

public class AndroidButton extends MobileButton {

    @Override
    public void renderButton() {
        System.out.println("Android Button");
    }
}
