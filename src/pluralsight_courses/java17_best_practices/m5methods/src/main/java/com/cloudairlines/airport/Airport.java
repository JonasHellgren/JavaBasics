package pluralsight_courses.java17_best_practices.m5methods.src.main.java.com.cloudairlines.airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

//skipped record

@Data
@AllArgsConstructor
@Getter
public class Airport {
     String country;
     String city;
     String name;
     List<Integer> terminals;
}
