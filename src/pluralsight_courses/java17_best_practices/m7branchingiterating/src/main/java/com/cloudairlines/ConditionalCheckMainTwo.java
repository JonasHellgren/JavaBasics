package pluralsight_courses.java17_best_practices.m7branchingiterating.src.main.java.com.cloudairlines;

import java.util.List;

public class ConditionalCheckMainTwo {

    static List<String> airports = List.of("New York", "London");

    public static void main(String[] args) {

        String input = args[0];

        if(input != null && input.isBlank() && airports.contains(input)) {
            // ...
        }

    }
}
