import org.exercices.exercice_5.Product;
import org.exercices.exercice_5.Shop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ShopTest {
    private Shop shop;

    Product sandwich = new Product("Sandwich à la Fraise", "Produit préparé", 0, 40);
    Product cheese = new Product("Brie vieilli", "Produit laitier", 25, 2);
    Product bread = new Product("Pain", "pain", 15, 75);
    Product yogourt = new Product("Yaourt", "Produit laitier", 10, 20);
    Product milk = new Product("Lait", "Produit laitier", 15, 20);
    Product meat = new Product("Steak haché Eco+", "Viande", 10, 0);

    @Before
    public void setUp() {
        shop = new Shop(List.of(sandwich, cheese, bread, milk, yogourt, meat));
    }

    @Test
    public void shouldDecrement2XQuality_WhenDurationEquals0() {
        int quality = sandwich.getQuality();
        shop.update();
        Assert.assertEquals(2, quality - sandwich.getQuality());
    }

    @Test
    public void qualityShouldNeverNegative_WhenUpdate() {
        shop.update();
        Assert.assertFalse(meat.getQuality() < 0);
    }

    @Test
    public void qualityShouldNeverBeGreaterThan50_WhenUpdate() {
        shop.update();
        Assert.assertFalse(bread.getQuality() > 50);
    }

    @Test
    public void productNameOfBrieVieilliShouldIncrementQuality_WhenUpdate() {
        int quality = cheese.getQuality();
        shop.update();
        Assert.assertTrue(quality < cheese.getQuality());
    }

    @Test
    public void productTypeOfProduitLaitierShouldDecrementQuality2XThanOther_WhenUpdate() {
        List<Product> milkProducts = shop.getProducts().stream().filter(
                p -> p.getType().equalsIgnoreCase("Produit laitier") && !p.getName().equalsIgnoreCase("Brie vieilli")
        ).toList();
        List<Integer> expectedArray = milkProducts.stream().map(p -> p.getQuality() - 2).toList();
        shop.update();
        Assert.assertEquals(expectedArray, milkProducts.stream().map(Product::getQuality).toList());
    }

}
