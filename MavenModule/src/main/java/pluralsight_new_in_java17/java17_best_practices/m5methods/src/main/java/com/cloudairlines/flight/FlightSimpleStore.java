package pluralsight_new_in_java17.java17_best_practices.m5methods.src.main.java.com.cloudairlines.flight;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class FlightSimpleStore {

    public List<Flight> getFlights(String json) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Flight> flights = null;
        try {
            flights = objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (IOException e) {
            // log or rethrow
        }
        return flights;
    }
}
