package pluralsight_new_in_java17.java17_best_practices.m5methods.src.main.java.com.cloudairlines.passenger;


import pluralsight_new_in_java17.java17_best_practices.m5methods.src.main.java.com.cloudairlines.flight.Flight;

import java.util.ArrayList;
import java.util.List;


public class PassengerSearch {

    public List<Passenger> findEconomyPassengers(Flight flight, boolean economy) {

        List<Passenger> foundPassengers = new ArrayList<>();

        for(Passenger passenger : flight.getPassengerList()){
            if(economy){
                if(passenger.getSeatClass().equals("Economy")) {
                    foundPassengers.add(passenger);
                }
            } else {
                if(!passenger.getSeatClass().equals("Economy")) {
                    foundPassengers.add(passenger);
                }
            }
        }
        return foundPassengers;
    }
}
