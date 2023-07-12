package pluralsight_new_in_java17.java17_best_practices.m5methods.src.main.java.com.cloudairlines;

import pluralsight_new_in_java17.java17_best_practices.m5methods.src.main.java.com.cloudairlines.flight.Flight;
import pluralsight_new_in_java17.java17_best_practices.m5methods.src.main.java.com.cloudairlines.flight.FlightStoreImpl;
import pluralsight_new_in_java17.java17_best_practices.m5methods.src.main.java.com.cloudairlines.passenger.PassengerSearch;

public class MainFlagArgument {


    public static void main(String[] args) {
        PassengerSearch paxSearch = new PassengerSearch();
        Flight flight = new FlightStoreImpl().getFlights().get(0);

        System.out.println("====== Economy ======");
        paxSearch
                .findEconomyPassengers(flight, true)
                .forEach(System.out::println);

        System.out.println("====== Non-Economy ======");
        paxSearch
                .findEconomyPassengers(flight, false)
                .forEach(System.out::println);
    }
}
