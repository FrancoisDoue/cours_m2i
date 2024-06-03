import jdk.jshell.spi.ExecutionControl;
import org.exercices.exercice_4.NotFoundException;
import org.exercices.exercice_4.SearchCity;
import org.junit.Assert;
import org.junit.Test;

public class SearchCityTest {

    private SearchCity searchCity;

    @Test public void shouldThrowNotFoundException_WhenLessOfTwoChar() throws ExecutionControl.NotImplementedException {
        searchCity = new SearchCity();
        Assert.assertThrows(NotFoundException.class, () -> searchCity.search("T"));
    }
}
