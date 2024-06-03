import org.exercices.exercice_2.Fib;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FibTest {
    private Fib fib;

    @Test public void shouldNotEmpty_WhenRangeIs1() {
        fib = new Fib(1);
        List<Integer> result = fib.getFibSeries();
        Assert.assertFalse(result.isEmpty());
    }

    @Test public void shouldContain0_WhenRangeIs1() {
        fib = new Fib(1);
        List<Integer> result = fib.getFibSeries();
        Assert.assertEquals(List.of(0), result);
    }

    @Test public void shouldContain3_WhenRangeIs6() {
        fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();
        Assert.assertTrue(result.contains(3));
    }

    @Test public void shouldHaveSizeOf6_WhenRangeIs6() {
        fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();
        Assert.assertEquals(6, result.size());
    }

    @Test public void shouldNotContain4_WhenRangeIs6() {
        fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();
        Assert.assertFalse(result.contains(4));
    }

    @Test public void shouldBeArrayOf0_1_1_2_3_5_WhenRangeIs6() {
        fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();
        List<Integer> expected = List.of(0,1,1,2,3,5);
        Assert.assertEquals(result, expected);
    }

    @Test public void shouldBeAscSorted_WhenRangeIs6() {
        fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();
        Assert.assertEquals(result.stream().sorted().toList(), result);
    }

}
