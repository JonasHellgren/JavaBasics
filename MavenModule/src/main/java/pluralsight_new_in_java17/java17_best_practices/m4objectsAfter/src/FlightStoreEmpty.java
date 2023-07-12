package pluralsight_new_in_java17.java17_best_practices.m4objectsAfter.src;

import java.util.Collections;
import java.util.List;

public class FlightStoreEmpty implements FlightStore{


    @Override
    public List<Flight> getFlights() {
        return Collections.emptyList();
    }
}
