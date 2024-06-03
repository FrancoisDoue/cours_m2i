import org.exercices.exercice_3.DiceScore;
import org.exercices.exercice_3.Ide;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


//@ExtendWith(MockitoExtension.class)
public class DiceScoreTest {

    private DiceScore diceScore;
    private Ide de = Mockito.mock(Ide.class);

    @Test public void shouldHaveSpecificValue_WhenSameDiceResult() {
        diceScore = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(4);
        int result = diceScore.getScore();
        int expected = 4*2+10;
        Assert.assertEquals(expected, result);
    }

    @Test public void shouldHave30_WhenDiceResultsIsDouble6() {
        diceScore = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(6);
        int result = diceScore.getScore();
        Assert.assertEquals(30, result);
    }

    @Test public void shouldHaveMax_WhenDiceResultsAreDifferent() {
        diceScore = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(3).thenReturn(5);
        int result = diceScore.getScore();
        Assert.assertEquals(5, result);
    }
}
