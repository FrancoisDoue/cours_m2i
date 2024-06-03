import org.exercices.exercice_1.GradientCalculator;
import org.junit.Assert;
import org.junit.Test;

public class GradientCalculatorTest {
    public GradientCalculator gradientCalculator;

    @Test
    public void shouldHaveA_WhenScore95AndPresence90 () {
        // Arrange
        gradientCalculator = new GradientCalculator(95, 90);
        // Act
        char result = gradientCalculator.getGrade();
        // Assert
        Assert.assertEquals('A', result);
    }
    @Test
    public void shouldHaveB_WhenScore85AndPresence90 () {
        // Arrange
        gradientCalculator = new GradientCalculator(85, 90);
        // Act
        char result = gradientCalculator.getGrade();
        // Assert
        Assert.assertEquals('B', result);
    }

    @Test
    public void shouldHaveC_WhenScore65AndPresence90 () {
        // Arrange
        gradientCalculator = new GradientCalculator(65, 90);
        // Act
        char result = gradientCalculator.getGrade();
        // Assert
        Assert.assertEquals('C', result);
    }

    @Test
    public void shouldHaveB_WhenScore95AndPresence65 () {
        // Arrange
        gradientCalculator = new GradientCalculator(95, 65);
        // Act
        char result = gradientCalculator.getGrade();
        // Assert
        Assert.assertEquals('B', result);
    }

    @Test
    public void shouldHaveF_WhenScore95AndPresence55 () {
        // Arrange
        gradientCalculator = new GradientCalculator(95, 55);
        // Act
        char result = gradientCalculator.getGrade();
        // Assert
        Assert.assertEquals('F', result);
    }

    @Test
    public void shouldHaveF_WhenScore65AndPresence55 () {
        // Arrange
        gradientCalculator = new GradientCalculator(65, 55);
        // Act
        char result = gradientCalculator.getGrade();
        // Assert
        Assert.assertEquals('F', result);
    }

    @Test
    public void shouldHaveF_WhenScore50AndPresence90 () {
        // Arrange
        gradientCalculator = new GradientCalculator(50, 90);
        // Act
        char result = gradientCalculator.getGrade();
        // Assert
        Assert.assertEquals('F', result);
    }

}
