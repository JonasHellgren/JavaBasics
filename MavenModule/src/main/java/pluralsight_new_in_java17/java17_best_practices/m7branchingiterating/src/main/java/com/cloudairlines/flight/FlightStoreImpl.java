package pluralsight_new_in_java17.java17_best_practices.m7branchingiterating.src.main.java.com.cloudairlines.flight;

import pluralsight_new_in_java17.java17_best_practices.m7branchingiterating.src.main.java.com.cloudairlines.airport.AirportStore;
import pluralsight_new_in_java17.java17_best_practices.m7branchingiterating.src.main.java.com.cloudairlines.passenger.Passenger;
import pluralsight_new_in_java17.java17_best_practices.m7branchingiterating.src.main.java.com.cloudairlines.passenger.SeatClass;

import java.util.List;

public class FlightStoreImpl implements FlightStore {

    public List<Flight> getFlights() {

        return List.of(
                new Flight(AirportStore.LONDON_GATWICK, AirportStore.NEW_YORK_JFK, "2022-10-15", PASSENGER_LIST),
                new Flight(AirportStore.LONDON_GATWICK, AirportStore.NEW_YORK_JFK, "2022-11-15", PASSENGER_LIST),
                new Flight(AirportStore.LONDON_GATWICK, AirportStore.PARIS_CDG, "2022-11-20", PASSENGER_LIST)
        );
    }

    private static final List<Passenger> PASSENGER_LIST = List.of(
            new Passenger("Smith", SeatClass.ECONOMY),
            new Passenger("Jones", SeatClass.ECONOMY),
            new Passenger("Taylor", SeatClass.ECONOMY),
            new Passenger("Brown", SeatClass.FIRST),
            new Passenger("Evans", SeatClass.BUSINESS)
    );
}
