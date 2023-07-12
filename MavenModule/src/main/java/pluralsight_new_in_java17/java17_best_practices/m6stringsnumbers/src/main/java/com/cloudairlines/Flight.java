package pluralsight_new_in_java17.java17_best_practices.m6stringsnumbers.src.main.java.com.cloudairlines;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flight {

    @JsonProperty("from")
    private String fromCity;
    @JsonProperty("to")
    private String toCity;
    @JsonProperty("date")
    private String date;


    public Flight() {}
    public Flight(String fromCity, String toCity, String date) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.date = date;
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
