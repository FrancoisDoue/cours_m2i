package org.design_patterns.exercices.tp_01.entity;

public class Warrior extends Character{

    private int armor;

    protected Warrior(WarriorBuilder builder) {
        super(builder);
        this.armor = builder.armor;
    }

    public static class WarriorBuilder extends AbstractCharacterBuilder {
        private int armor;

        public WarriorBuilder armor( int armor ) {
            this.armor = armor;
            return this;
        }

        @Override
        public Character build() {
            return new Warrior(this);
        }
    }
}
