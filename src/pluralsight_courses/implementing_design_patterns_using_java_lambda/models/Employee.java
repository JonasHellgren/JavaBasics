package pluralsight_courses.implementing_design_patterns_using_java_lambda.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Employee {
    private final String name;
    private final double salary;
}
