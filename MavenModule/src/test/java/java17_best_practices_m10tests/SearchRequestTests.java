package java17_best_practices_m10tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pluralsight_new_in_java17.java17_best_practices.m10tests.src.main.java.com.cloudairlines.airport.AirportStore;
import pluralsight_new_in_java17.java17_best_practices.m10tests.src.main.java.com.cloudairlines.flight.Flight;
import pluralsight_new_in_java17.java17_best_practices.m10tests.src.main.java.com.cloudairlines.flight.FlightSearch;
import pluralsight_new_in_java17.java17_best_practices.m10tests.src.main.java.com.cloudairlines.flight.FlightStore;
import pluralsight_new_in_java17.java17_best_practices.m10tests.src.main.java.com.cloudairlines.flight.SearchRequest;

import java.util.List;

public class SearchRequestTests {

    @Test
    public void sameInputFails() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SearchRequest("London", "London", "2022-07-15")) ;
    }


    @ParameterizedTest
    @CsvSource({
            "    ,New York,2022-10-16",
            "London,    ,2022-10-16",
            "London,London,2022-10-16"
    })
    public void invalidInputIsRejected(String from, String to, String date) {

        if(from == null || to == null) {
            Assertions.assertThrows(NullPointerException.class,
                    () -> new SearchRequest(from, to, date));
        } else {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new SearchRequest(from, to, date));
        }
    }

    @Test
    public void searchRejectsInvalidDateFormat() {
        List<String> invalidDates = List.of("2022-07/15", "2022-13-15", "01-01-2024");
        for(String date : invalidDates) {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new SearchRequest("London", "New York", date));
        }
    }

    @Test
    public void searchReturnsCorrectNumberOfFlights() {
        var request = new SearchRequest("London", "New York", "2022-10-15");
        var flightSearch = new FlightSearch(new TestFlightStore());

        var foundFlights = flightSearch.search(request);

        Assertions.assertEquals(1, foundFlights.size());
    }


    private class TestFlightStore implements FlightStore {
        @Override
        public List<Flight> getFlights() {
            return List.of(
                    new Flight(AirportStore.LONDON_GATWICK, AirportStore.NEW_YORK_JFK, "2022-10-15"),
                    new Flight(AirportStore.LONDON_GATWICK, AirportStore.NEW_YORK_JFK, "2022-11-15"),
                    new Flight(AirportStore.LONDON_GATWICK, AirportStore.PARIS_CDG, "2022-11-20")
            );
        }
    }
}
