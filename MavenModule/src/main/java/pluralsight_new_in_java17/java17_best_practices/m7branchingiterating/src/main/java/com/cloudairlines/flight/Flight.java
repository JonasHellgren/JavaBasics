package pluralsight_new_in_java17.java17_best_practices.m7branchingiterating.src.main.java.com.cloudairlines.flight;


import com.fasterxml.jackson.annotation.JsonProperty;
import pluralsight_new_in_java17.java17_best_practices.m7branchingiterating.src.main.java.com.cloudairlines.airport.Airport;
import pluralsight_new_in_java17.java17_best_practices.m7branchingiterating.src.main.java.com.cloudairlines.passenger.Passenger;

import java.util.List;

public class Flight {

    private Airport fromAirport;
    private Airport toAirport;

    @JsonProperty("from")
    private String fromCity;
    @JsonProperty("to")
    private String toCity;
    @JsonProperty("date")
    private String date;

    private int seatCapacity;
    private List<Passenger> passengerList;

    public Flight() {}
    public Flight(String fromCity, String toCity, String date) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.date = date;
    }


    public Flight(Airport fromAirport, Airport toAirport, String date, List<Passenger> passengerList) {
        this.fromAirport = fromAirport;
        this.fromCity = fromAirport.getCity();

        this.toAirport = toAirport;
        this.toCity = toAirport.getCity();

        this.date = date;
        this.passengerList = passengerList;
        this.seatCapacity = 150;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
