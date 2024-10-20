package hellgren.stream_examples;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * https://blog.devgenius.io/top-10-essential-stream-operations-in-java-eee880973fd3
 */

public class EmployeeStreamMedium {

    enum Gender {
        MALE, FEMALE
    }

    record Employee(String name, int age, int salary, Gender gender) {
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 20, 2000, Gender.MALE);
        Employee employee2 = new Employee("Jane", 28, 2000, Gender.FEMALE);
        Employee employee3 = new Employee("Alex", 38, 2750, Gender.MALE);
        Employee employee4 = new Employee("Mary", 35, 3500, Gender.FEMALE);
        Employee employee5 = new Employee("Pedro", 40, 3100, Gender.MALE);

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5);

        assert totalSalaryOfMaleAgedOver35(employees) == 2750 + 3100;
        assert isAnyfemaleEmployeeUnderTheAgeOf30WithName("Jane", employees);
        assert totalalary(employees) > 2000 * 5;
        assert topThreeHighestSalaries(employees).equals(List.of(3500, 3100, 2750));
        assert totalSalaryForEachGenderGroup(employees).equals(
                Map.of(Gender.FEMALE, 2000 + 3500,
                        Gender.MALE, 2000 + 2750 + 3100));
        assert highestPaidEmployeeForGender(Gender.MALE, employees).orElseThrow().equals(employee5);

        // ...
    }

    static double totalSalaryOfMaleAgedOver35(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.age() > 35 && e.gender() == Gender.MALE)
                .mapToDouble(e -> e.salary())
                .sum();
    }

    static boolean isAnyfemaleEmployeeUnderTheAgeOf30WithName(String name, List<Employee> employees) {
        return employees.stream()
                .anyMatch(e -> e.name().equals(name) && e.age() < 30 && e.gender() == Gender.FEMALE);
    }

    static double totalalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(e -> e.salary()).reduce(0, Double::sum);
    }

    static List<Integer> topThreeHighestSalaries(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.salary())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
    }

    static Map<Gender, Integer> totalSalaryForEachGenderGroup(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.gender(),
                        Collectors.summingInt(e -> e.salary())));
    }

    static double  averageSalaryOfGender(List<Employee> employees, Gender gender) {
        return employees.stream()
                .filter(e -> e.gender() == gender)
                .mapToDouble(e -> e.salary())
                .average()
                .orElse(0.0);
    }

    static Map<Gender,Long> employeesPerGender(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.gender(),
                        Collectors.counting()));
    }

    static Optional<Employee> highestPaidEmployeeForGender(Gender gender, List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.gender() == gender)
                .max(Comparator.comparing(e -> e.salary()));
    }

    static int numberOfEmployeesWithSalaryOver(int threshold, List<Employee> employees) {
        return (int) employees.stream()
                .filter(e -> e.salary() > threshold)
                .count();


}
