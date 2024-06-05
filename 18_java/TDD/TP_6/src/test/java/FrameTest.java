import org.exercices.Frame;
import org.exercices.IGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class FrameTest {

    private Frame frame;
    private final IGenerator generator = Mockito.mock(IGenerator.class);

    @Before
    public void setUpStandardFrame() {
        frame = new Frame(false, generator);
    }

    @Test
    public void roll_SimpleFrame_FirstRoll_CheckScore() {
        Mockito.when(generator.randomPin(10)).thenReturn(8);
        frame.makeRoll();
        Assert.assertEquals(8, frame.getScore());
    }

    @Test
    public void roll_SimpleFrame_SecondRoll_CheckScore() {
        Mockito.when(generator.randomPin(10)).thenReturn(3).thenReturn(6);
        for (int i = 0; i < 2; i++) frame.makeRoll();
        Assert.assertEquals(9, frame.getScore());
    }

    @Test
    public void roll_SimpleFrame_SecondRoll_FirstRollStrike_ReturnFalse() {
        Mockito.when(generator.randomPin(10)).thenReturn(10).thenReturn(3);
        frame.makeRoll();
        Assert.assertFalse(frame.makeRoll());
    }

    @Test
    public void roll_SimpleFrame_MoreRolls_ReturnFalse() {
        Mockito.when(generator.randomPin(10)).thenReturn(4,3);
        for (int i = 0; i < 2; i++) frame.makeRoll();
        Assert.assertFalse(frame.makeRoll());
    }

    @Test
    public void roll_LastFrame_SecondRoll_FirstRollStrike_ReturnTrue() {
        Mockito.when(generator.randomPin(10)).thenReturn(0).thenReturn(2);
        frame.setLastFrame(true);
        frame.makeRoll();
        Assert.assertTrue(frame.makeRoll());
    }

    @Test
    public void roll_LastFrame_SecondRoll_FirstRollStrike_CheckScore() {
        Mockito.when(generator.randomPin(10)).thenReturn(10).thenReturn(2);
        frame.setLastFrame(true);
        for (int i = 0; i < 2; i++) frame.makeRoll();
        Assert.assertEquals(12, frame.getScore());
    }

    @Test
    public void roll_LastFrame_ThirdRoll_FirstRollStrike_ReturnTrue() {
        Mockito.when(generator.randomPin(10)).thenReturn(10).thenReturn(2).thenReturn(8);
        frame.setLastFrame(true);
        for (int i = 0; i < 3; i++) Assert.assertTrue(frame.makeRoll());
    }

    @Test
    public void roll_LastFrame_ThirdRoll_FirstRollStrike_CheckScore() {
        Mockito.when(generator.randomPin(10)).thenReturn(10).thenReturn(8).thenReturn(2);
        frame.setLastFrame(true);
        for (int i = 0; i < 3; i++) frame.makeRoll();
        Assert.assertEquals(20, frame.getScore());
    }
    @Test
    public void roll_LastFrame_ThirdRoll_Spare_ReturnTrue() {
        Mockito.when(generator.randomPin(10)).thenReturn(6).thenReturn(4).thenReturn(9);
        frame.setLastFrame(true);
        for (int i = 0; i < 3; i++) Assert.assertTrue(frame.makeRoll());
    }

    @Test
    public void roll_LastFrame_ThirdRoll_Spare_CheckScore() {
        Mockito.when(generator.randomPin(10)).thenReturn(6).thenReturn(4).thenReturn(9);
        frame.setLastFrame(true);
        for (int i = 0; i < 3; i++) frame.makeRoll();
        Assert.assertEquals(19, frame.getScore());
    }

    @Test
    public void roll_LastFrame_FourthRoll_ReturnFalse() {
        Mockito.when(generator.randomPin(10)).thenReturn(6,3, 6, 1, 6);
        frame.setLastFrame(true);
        for (int i = 0; i < 4; i++) Assert.assertTrue(frame.makeRoll());
        Assert.assertFalse(frame.makeRoll());
    }

}
