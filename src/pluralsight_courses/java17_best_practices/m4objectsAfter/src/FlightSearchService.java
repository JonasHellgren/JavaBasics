package pluralsight_courses.java17_best_practices.m4objectsAfter.src;

import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchService {

    private FlightStore flightStore;


    public FlightSearchService() {
        this.flightStore = new FlightStoreEmpty();
    }

    public static FlightSearchService newFlightSearchServiceEmptyStore() {
        return new FlightSearchService();
    }

    public static FlightSearchService newFlightSearchServiceMockedStore() {
        return new FlightSearchService(new FlightStoreMocked());
    }

    public FlightSearchService(FlightStore flightStore) {
        this.flightStore = flightStore;
    }

    public List<Flight> search(String fromDest, String toDest, String departDate){
        List<Flight> flights = flightStore.getFlights();

        List<Flight> availableFlights = flights.stream()
                .filter( f -> f.getFromDest().equals(fromDest))
                .filter( f -> f.getToDest().equals(toDest))
                .filter( f -> f.getDate().equals(departDate))
                .collect(Collectors.toList());

        // we'll implement the search later
        return availableFlights;
    }

    public List<Flight> allFlightsInStore(){
        return flightStore.getFlights();
    }
}
