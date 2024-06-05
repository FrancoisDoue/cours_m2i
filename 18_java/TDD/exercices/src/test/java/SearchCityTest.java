import jdk.jshell.spi.ExecutionControl;
import org.exercices.exercice_4.NotFoundException;
import org.exercices.exercice_4.SearchCity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SearchCityTest {

    private SearchCity searchCity;
    private final List<String> cities = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

    @Before
    public void setUp() {
        searchCity = new SearchCity(cities);
    }

    @Test
    public void shouldThrowNotFoundException_WhenLessOfTwoChar() throws ExecutionControl.NotImplementedException {
        Assert.assertThrows(NotFoundException.class, () -> searchCity.search("T"));
    }

    @Test
    public void shouldHaveTwoCitiesForVa_WhenMoreOfTwoChar() {
        List<String> result = searchCity.search("Va");
        Assert.assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    public void shouldNotBeCaseSensitive_WhenMoreOfTwoChar() {
        List<String> result = searchCity.search("paris");
        Assert.assertEquals(List.of("Paris"), result);
    }

    @Test
    public void shouldAllowPartialSearch_WhenMoreOfTwoChar() {
        List<String> result = searchCity.search("ape");
        Assert.assertTrue(result.contains("Budapest"));
    }

    @Test
    public void shouldReturnAll_WhenAsteriskCharacter() {
        List<String> result = searchCity.search("*");
        Assert.assertEquals(cities, result);
    }
}