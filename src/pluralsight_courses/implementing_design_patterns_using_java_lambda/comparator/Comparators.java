package pluralsight_courses.implementing_design_patterns_using_java_lambda.comparator;


import pluralsight_courses.implementing_design_patterns_using_java_lambda.models.Employee;

import java.util.Comparator;

public class Comparators {

    public static Comparator<Integer> intComparatorSmallFirst
            = Comparator.comparingInt(h -> h);  //= (h1, h2) -> h1-h2;

    public static Comparator<Integer> intComparatorLargeFirst
            = intComparatorSmallFirst.reversed();

    public static Comparator<Employee> employeeComparatorLowestSalaryFirst
            = (h1, h2) -> (int) (h1.getSalary() - h2.getSalary());
    
    public static Comparator<Employee> employeeComparatorLargestSalaryFirst
            = employeeComparatorLowestSalaryFirst.reversed();


}
