package pluralsight_courses.java17_best_practices.m10tests.src.main.java.com.cloudairlines.airport;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

//skipped record

@Data
@AllArgsConstructor
public class Airport {
    String country;
    String city;
    String name;
    List<Integer> terminals;
}
