import org.exercices.exercice4.NotFoundException;
import org.exercices.exercice4.SearchCity;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SearchCityTest {

    private SearchCity searchCity;

    @Test public void shouldThrowNotFoundException_WhenLessOfTwoChar() {
        searchCity = new SearchCity();
        Assert.assertThrows(NotFoundException.class, () -> searchCity.search("T"));
    }
    @Test public void shouldHaveTwoCitiesForVa_WhenMoreOfTwoChar() {
        searchCity = new SearchCity();
        List<String> cities = searchCity.search("Va");
        Assert.assertEquals(List.of("Valence", "Vancouver"), cities);
    }

    @Test public void shouldBeNotCaseSensitive_WhenMoreOfTwoChar() {
        searchCity = new SearchCity();
        List<String> cities = searchCity.search("paris");
        Assert.assertEquals(List.of("Paris"), cities);
    }


}
