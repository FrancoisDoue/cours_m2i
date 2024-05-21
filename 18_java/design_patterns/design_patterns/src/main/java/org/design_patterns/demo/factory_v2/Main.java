package org.design_patterns.demo.factory_v2;

import org.design_patterns.demo.factory_v2.factory.Impl.AndroidUIFactory;
import org.design_patterns.demo.factory_v2.factory.Impl.IosUIFactory;
import org.design_patterns.demo.factory_v2.factory.Impl.MobileApplication;

public class Main {
    public static void main(String[] args) {

        MobileApplication ios = new MobileApplication(new IosUIFactory());
        ios.renderApplication();

        MobileApplication android = new MobileApplication(new AndroidUIFactory());
        android.renderApplication();

    }
}
