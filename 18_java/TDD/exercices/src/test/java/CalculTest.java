import org.demo.Calcul;
import org.junit.Assert;
import org.junit.Test;

public class CalculTest {

    private Calcul calcul;

    @Test
    public void WhenAddingOneAndTwo_ThenGetThree () {
        // Arrange
        calcul = new Calcul();
        double a = 1;
        double b = 2;
        // Act
        double result = calcul.addition(a,b);
        // Assert
        Assert.assertEquals(3, result,0.01);
    }

    @Test
    public void WhenDivivion_30_10_ThenGet_3 () {
        calcul = new Calcul();
        double a = 30;
        double b = 10;
        double result = calcul.division(a,b);
        Assert.assertEquals(3, result,0.01);
    }

    @Test
    public void WhenMultiplicationBy_0_ThenThrowArithmeticException () {
        // Arrange
        calcul = new Calcul();
        double a = 3;
        double b = 0;
        // Act + Assert
        Assert.assertThrows(ArithmeticException.class, () -> calcul.division(a,b));
    }
}
