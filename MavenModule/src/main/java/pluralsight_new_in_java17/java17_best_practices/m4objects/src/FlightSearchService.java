package pluralsight_new_in_java17.java17_best_practices.m4objects.src;

import java.util.List;

public class FlightSearchService {

    private FlightStore flightStore;


    public FlightSearchService(){
        this.flightStore = new FlightStoreImpl();
    }

    public List<Flight> search(String fromDest, String toDest, String departDate){
        List<Flight> availableFlights = flightStore.getFlights();

        // we'll implement the search later
        return availableFlights;
    }
}
