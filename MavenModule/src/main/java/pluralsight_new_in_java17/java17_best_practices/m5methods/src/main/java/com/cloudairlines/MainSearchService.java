package pluralsight_new_in_java17.java17_best_practices.m5methods.src.main.java.com.cloudairlines;

import pluralsight_new_in_java17.java17_best_practices.m5methods.src.main.java.com.cloudairlines.flight.Flight;
import pluralsight_new_in_java17.java17_best_practices.m5methods.src.main.java.com.cloudairlines.flight.FlightSearch;

import java.util.List;

public class MainSearchService {

    public static void main(String[] args) {

        FlightSearch searchService = FlightSearch.newSearch();

        List<Flight> foundFlights =
                searchService.search("London", "New York", "2022-10-15");

    }
}
