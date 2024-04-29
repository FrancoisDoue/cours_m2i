package org.design_patterns.exercices.exo_02_factory.italian;

import org.design_patterns.exercices.exo_02_factory.abstract_classes.CookingUstensil;

public class ItalianUstensil extends CookingUstensil {

    @Override
    public void use() {
        System.out.println("Vous utilisez des ustensiles italiens");
    }
}
