import jdk.jshell.spi.ExecutionControl;
import org.exercices.exercice_4.NotFoundException;
import org.exercices.exercice_4.SearchCity;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SearchCityTest {

    private SearchCity searchCity;

    @Test public void shouldThrowNotFoundException_WhenLessOfTwoChar() throws ExecutionControl.NotImplementedException {
        searchCity = new SearchCity();
        Assert.assertThrows(NotFoundException.class, () -> searchCity.search("T"));
    }

    @Test public void shouldHaveTwoCitiesForVa_WhenMoreOfTwoChar() {
        searchCity = new SearchCity();
        List<String> result = searchCity.search("Va");
        Assert.assertEquals(result, List.of("Valence", "Vancouver"));
    }
}