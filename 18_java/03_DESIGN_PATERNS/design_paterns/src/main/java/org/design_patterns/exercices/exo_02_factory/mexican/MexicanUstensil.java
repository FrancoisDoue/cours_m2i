package org.design_patterns.exercices.exo_02_factory.mexican;

import org.design_patterns.exercices.exo_02_factory.abstract_classes.CookingUstensil;

public class MexicanUstensil extends CookingUstensil {

    @Override
    public void use() {
        System.out.println("Vous utilisez des ustensiles mexicains");
    }
}
