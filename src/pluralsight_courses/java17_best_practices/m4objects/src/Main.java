package pluralsight_courses.java17_best_practices.m4objects.src;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        FlightSearchService searchService = new FlightSearchService();
        List<Flight> foundFlights = searchService.search("New York", "London", "2022-07-22");

        foundFlights.forEach(System.out::println);
    }
}
