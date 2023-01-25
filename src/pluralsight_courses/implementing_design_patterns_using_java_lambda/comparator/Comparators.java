package pluralsight_courses.implementing_design_patterns_using_java_lambda.comparator;


import pluralsight_courses.implementing_design_patterns_using_java_lambda.models.Employee;

import java.util.Comparator;

public class Comprators {

    public static Comparator<Integer> intComparatorSmallFirst
            = (h1, h2) -> h1-h2;

    public static Comparator<Integer> intComparatorLargeFirst
            = intComparatorSmallFirst.reversed();

    public static Comparator<Employee> employeeComparatorLowSalaryFirst
            = (h1, h2) -> (int) (h1.getSalary() - h2.getSalary());


    public static Comparator<Employee> employeeComparatorLargeSalaryFirst
            = employeeComparatorLowSalaryFirst.reversed();


}
