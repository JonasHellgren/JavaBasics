package pluralsight_new_in_java17.java17_best_practices.m10tests.src.main.java.com.cloudairlines.flight;



import com.cloudairlines.airport.AirportStore;

import java.util.List;

public class FlightStoreImpl implements FlightStore {

    public List<Flight> getFlights() {

        return List.of(
                new Flight(AirportStore.LONDON_GATWICK, AirportStore.NEW_YORK_JFK, "2022-10-15"),
                new Flight(AirportStore.LONDON_GATWICK, AirportStore.NEW_YORK_JFK, "2022-11-15"),
                new Flight(AirportStore.LONDON_GATWICK, AirportStore.PARIS_CDG, "2022-11-20")
        );
    }
}
