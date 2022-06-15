package pluralsight_courses.java17_best_practices.m4objects.test;

import org.junit.Test;
import pluralsight_courses.java17_best_practices.m4objects.src.Flight;
import pluralsight_courses.java17_best_practices.m4objects.src.FlightSearchService;

import java.util.List;

public class FlightSearchServiceTest {

    @Test
    public void quickFlightSearchTest() {
        var search = new FlightSearchService();
        List<Flight> flights = search.search("London", "Paris", "2022-07-22");
        // assert things
    }
}
