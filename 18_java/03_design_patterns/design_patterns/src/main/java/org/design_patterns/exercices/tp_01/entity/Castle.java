package org.design_patterns.exercices.tp_01.entity;

public class Castle extends Building {

    private String style;
    private String name;

    private Castle(CastleBuilder builder) {
        this.level = builder.level;
        this.size = builder.size;
        this.name = builder.name;
        this.style = builder.style;
    }

    public static class CastleBuilder extends AbstractBuildingBuilder {

        private String style;
        private String name;

        public CastleBuilder style(String style) {
            this.style = style;
            return this;
        }
        public CastleBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public CastleBuilder level(int level) {
            this.level = level;
            return this;
        }
        @Override
        public CastleBuilder size(int size) {
            this.size = size;
            return this;
        }

        @Override
        public Castle build() {
            return new Castle(this);
        }
    }

    @Override
    public String toString() {
        return "Castle{" +
                "style='" + style + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", size=" + size +
                '}';
    }
}
