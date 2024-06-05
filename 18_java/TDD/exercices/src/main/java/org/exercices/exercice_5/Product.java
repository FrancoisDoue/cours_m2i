package org.exercices.exercice_5;

public class Product {
    private final String name;
    private final String type;
    private int sellIn;
    private int quality;

    public Product(String name, String type, int sellIn, int quality) {
        this.name = name;
        this.type = type;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
