import jdk.jshell.spi.ExecutionControl;
import org.exercices.exercice_4.NotFoundException;
import org.exercices.exercice_4.SearchCity;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SearchCityTest {

    private SearchCity searchCity;

    @Test
    public void shouldThrowNotFoundException_WhenLessOfTwoChar() throws ExecutionControl.NotImplementedException {
        searchCity = new SearchCity();
        Assert.assertThrows(NotFoundException.class, () -> searchCity.search("T"));
    }

    @Test
    public void shouldHaveTwoCitiesForVa_WhenMoreOfTwoChar() {
        searchCity = new SearchCity();
        List<String> result = searchCity.search("Va");
        Assert.assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    public void shouldBeNotCaseSensitive_WhenMoreOfTwoChar() {
        searchCity = new SearchCity();
        List<String> result = searchCity.search("paris");
        Assert.assertEquals(List.of("Paris"), result);
    }

    @Test public void shouldAllowPartialSearch_WhenMoreOfTwoChar() {
        searchCity = new SearchCity();
        List<String> result = searchCity.search("ape");
        Assert.assertTrue(result.contains("Budapest"));
    }

    @Test public void shouldReturnAll_WhenStarCharacter() {
        searchCity = new SearchCity();
        List<String> result = searchCity.search("*");
        List<String> expected = searchCity.getCities();
        Assert.assertEquals(expected, result);
    }
}