import org.exercices.Frame;
import org.exercices.IGenerator;
import org.exercices.Roll;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class FrameTest {

    private Frame frame;
    private final IGenerator generator = Mockito.mock(IGenerator.class);

    @Test
    public void roll_SimpleFrame_FirstRoll_CheckScore() {
        Mockito.when(generator.randomPin(10)).thenReturn(8);
        frame = new Frame(0, false, generator);
        frame.makeRoll();
        Assert.assertEquals(8, frame.getScore());
    }

    @Test
    public void roll_SimpleFrame_SecondRoll_CheckScore() {
        Mockito.when(generator.randomPin(10)).thenReturn(9);
        frame = new Frame(8, false, generator);
        frame.getRolls().add(new Roll(8));
        frame.makeRoll();
        Assert.assertEquals(2, frame.getRolls().size());
        Assert.assertEquals(17, frame.getScore());
    }

    @Test
    public void roll_SimpleFrame_SecondRoll_FirstRollStrick_ReturnFalse() {
        Mockito.when(generator.randomPin(10)).thenReturn(10);
        frame = new Frame(0, false, generator);
        frame.makeRoll();
        Assert.assertFalse(frame.makeRoll());
    }



}
