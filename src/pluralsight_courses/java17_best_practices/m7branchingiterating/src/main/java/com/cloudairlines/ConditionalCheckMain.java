package pluralsight_courses.java17_best_practices.m7branchingiterating.src.main.java.com.cloudairlines;

import java.time.LocalDateTime;

public class ConditionalCheckMain {

    public static void main(String[] args) {

        int hour = LocalDateTime.now().getHour();

        if(hour > 6 && hour < 22) {
            // display day shift flights
        } else {
            // display night shift flights
        }
    }
}
