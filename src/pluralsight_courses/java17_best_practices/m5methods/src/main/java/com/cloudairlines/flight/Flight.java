package pluralsight_courses.java17_best_practices.m5methods.src.main.java.com.cloudairlines.flight;



import pluralsight_courses.java17_best_practices.m10tests.src.main.java.com.cloudairlines.airport.Airport;
import pluralsight_courses.java17_best_practices.m3namingAfter.cloudairlines.Passenger;

import java.util.List;

public class Flight {

    private Airport fromAirport;
    private Airport toAirport;

   // @JsonProperty("from")
    private String fromCity;
   // @JsonProperty("to")
    private String toCity;
    //@JsonProperty("date")
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

    @Override
    public String toString() {
        return "Flight{" +
                "fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
