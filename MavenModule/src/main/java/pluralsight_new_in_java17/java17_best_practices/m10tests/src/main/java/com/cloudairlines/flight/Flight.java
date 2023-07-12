package pluralsight_new_in_java17.java17_best_practices.m10tests.src.main.java.com.cloudairlines.flight;


import pluralsight_new_in_java17.java17_best_practices.m10tests.src.main.java.com.cloudairlines.airport.Airport;

public class Flight {

    private Airport fromAirport;
    private Airport toAirport;

    private String fromCity;
    private String toCity;
    private String date;

    public Flight() {}
    public Flight(String fromCity, String toCity, String date) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.date = date;
    }

    public Flight(Airport fromAirport, Airport toAirport, String date) {
        this.fromAirport = fromAirport;
        this.fromCity = fromAirport.getCity();

        this.toAirport = toAirport;
        this.toCity = toAirport.getCity();

        this.date = date;
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
