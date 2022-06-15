package pluralsight_courses.java17_best_practices.m4objectsAfter.src;

import java.util.List;

public class FlightStoreMocked implements FlightStore {

    public FlightStoreMocked() {
    }

    @Override
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
