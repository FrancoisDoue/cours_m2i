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
    public void roll_SimpleFrame_SecondRoll_FirstRollStrike_ReturnFalse() {
        Mockito.when(generator.randomPin(10)).thenReturn(10).thenReturn(3);
        frame = new Frame(0, false, generator);
        frame.makeRoll();
        Assert.assertFalse(frame.makeRoll());
    }

    @Test
    public void roll_SimpleFrame_MoreRolls_ReturnFalse() {
        Mockito.when(generator.randomPin(10))
                .thenReturn(4)
                .thenReturn(4)
                .thenReturn(4);
        frame = new Frame(0, false, generator);
        for (int i = 0; i < 2; i++) frame.makeRoll();
        Assert.assertFalse(frame.makeRoll());
    }

    @Test
    public void roll_LastFrame_SecondRoll_FirstRollStrike_ReturnTrue() {
        Mockito.when(generator.randomPin(10)).thenReturn(10).thenReturn(2);
        frame = new Frame(0, true, generator);
        frame.makeRoll();
        Assert.assertTrue(frame.makeRoll());
    }

    @Test
    public void roll_LastFrame_SecondRoll_FirstRollStrike_CheckScore() {
        Mockito.when(generator.randomPin(10)).thenReturn(10).thenReturn(2);
        frame = new Frame(0, true, generator);
        for (int i = 0; i < 2; i++) frame.makeRoll();
        Assert.assertEquals(12, frame.getScore());
    }

    @Test
    public void roll_LastFrame_ThirdRoll_FirstRollStrike_ReturnTrue() {
        Mockito.when(generator.randomPin(10)).thenReturn(10).thenReturn(2).thenReturn(8);
        frame = new Frame(0, true, generator);
        for (int i = 0; i < 2; i++)
            frame.makeRoll();
        Assert.assertTrue(frame.makeRoll());
    }

    @Test
    public void roll_LastFrame_ThirdRoll_FirstRollStrike_CheckScore() {
        Mockito.when(generator.randomPin(10)).thenReturn(8).thenReturn(10).thenReturn(8);
        frame = new Frame(0, true, generator);
        for (int i = 0; i < 3; i++)
            frame.makeRoll();
        Assert.assertEquals(26, frame.getScore());
    }
    @Test
    public void roll_LastFrame_ThirdRoll_Spare_ReturnTrue() {
        Mockito.when(generator.randomPin(10)).thenReturn(6).thenReturn(4).thenReturn(9);
        frame = new Frame(0, true, generator);
        for (int i = 0; i < 2; i++) frame.makeRoll();
        Assert.assertTrue(frame.makeRoll());
    }

}
