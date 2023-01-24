package pluralsight_courses.implementing_design_patterns_using_java_lambda.predicate;

import pluralsight_courses.implementing_design_patterns_using_java_lambda.models.Employee;

import java.util.function.Predicate;

public class Predicates {

   public static Predicate<String> stringNotNullOrEmptyPredicate = s -> (s != null) && !s.isEmpty();

   public static Predicate<String> stringIsNullOrEmpty=stringNotNullOrEmptyPredicate.negate();

   public static Predicate<String> stringIsShorterThan5 = s -> s.length() < 5;

   public static Predicate<Employee> employeeNameIsShorterThan5 = s -> s.getName().length() < 5;

   public static Predicate<Employee> employeeNameIsNotShorterThan5 = employeeNameIsShorterThan5.negate();

   public static Predicate<Employee> employeeSalaryLowerThan20k = s -> s.getSalary() < 20_000;


}
