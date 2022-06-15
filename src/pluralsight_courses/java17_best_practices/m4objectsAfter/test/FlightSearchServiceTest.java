package pluralsight_courses.java17_best_practices.m4objectsAfter.test;

import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import pluralsight_courses.java17_best_practices.m4objectsAfter.src.Flight;
import pluralsight_courses.java17_best_practices.m4objectsAfter.src.FlightSearchService;
import pluralsight_courses.java17_best_practices.m4objectsAfter.src.FlightStore;

import java.util.List;

public class FlightSearchServiceTest {


    @Test
    public void quickFlightSearchTest1() {
        var search = new FlightSearchService(new FlightStoreImpl());
        List<Flight> flights = search.search("London", "Paris", "2022-07-22");

        System.out.println("flights = " + flights);
        Assert.assertEquals(0,flights.size());
    }

    @Test
    public void quickFlightSearchTest2() {
        var search = new FlightSearchService(new FlightStoreImpl());
        List<Flight> flights = search.search("London", "Paris", "2022-11-20");

        System.out.println("flights = " + flights);
        Assert.assertEquals(1,flights.size());
    }


    @Test
    public void quickFlightSearchTest3() {
        var search =  FlightSearchService.newFlightSearchServiceEmptyStore();
        List<Flight> flights = search.search("London", "Paris", "2022-07-22");

        System.out.println("flights = " + flights);
        Assert.assertEquals(0,flights.size());
    }

    @Test
    public void quickFlightSearchTest4() {
        var search =  FlightSearchService.newFlightSearchServiceMockedStore();
        List<Flight> flights = search.allFlightsInStore();

        System.out.println("nof flights = " + flights.size());
        Assert.assertTrue(flights.size()>0);
    }

    //following makes test independent

    @NoArgsConstructor
    private class FlightStoreImpl implements FlightStore {

        public List<Flight> getFlights() {

            return List.of(
                    // ISO 8601 format YYYY-MM-DD
                    new Flight("London", "New York", "2022-10-15"),
                    new Flight("London", "New York", "2022-11-15"),

                    new Flight("London", "Paris", "2022-11-20"),
                    new Flight("Amsterdam", "Paris", "2022-11-25"),

                    new Flight("Boston", "Chicago", "2022-12-10"),
                    new Flight("Boston", "Chicago", "2022-12-15"),

                    new Flight("Dubai", "New Delhi", "2023-02-05"),
                    new Flight("Frankfurt", "Moscow", "2023-03-10")
            );
        }
    }

}
