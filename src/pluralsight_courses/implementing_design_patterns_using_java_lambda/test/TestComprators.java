package pluralsight_courses.implementing_design_patterns_using_java_lambda.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pluralsight_courses.implementing_design_patterns_using_java_lambda.comparator.Comparators;
import pluralsight_courses.implementing_design_patterns_using_java_lambda.models.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * negative integer(-1) « if first argument is less than the other
 * zero             (0) « if both are equal
 * positive integer (1) « if first greater than the second.
 */

public class TestComprators {

    private static final int DELTA = 1;
    private static final int INDEX_OF_FIRST = 0;
    private static final int LARGEST_SALARY = 60_000;
    List<Integer> integerList;
    List<Employee> employees;

    @Before
    public void init() {
        employees = Arrays.asList(
                new Employee("Jonas", LARGEST_SALARY),
                new Employee("Katja", 40_000),
                new Employee("Alex", INDEX_OF_FIRST)
        );

        integerList = Arrays.asList(1, 3, 8, 6);
    }

    @Test
    public void oneIsSmallerThanThree() {
        int compResult = Comparators.intComparatorSmallFirst.compare(1, 3);
        Assert.assertEquals(-1, Integer.signum(compResult));   //first argument is less than the other <=> -1
    }

    @Test
    public void firstInSortedSmallFirstIs1() {
        integerList.sort(Comparators.intComparatorSmallFirst);
        System.out.println("integerList = " + integerList);
        Assert.assertEquals(1, integerList.get(INDEX_OF_FIRST).intValue());
    }

    @Test
    public void firstInSortedLargeFirstIs8() {
        integerList.sort(Comparators.intComparatorLargeFirst);
        System.out.println("integerList = " + integerList);
        Assert.assertEquals(8, integerList.get(INDEX_OF_FIRST).intValue());
    }

    @Test
    public void givenEmployees_firstInSortedSmallFirstIs1() {
        employees.sort(Comparators.employeeComparatorLowestSalaryFirst);
        employees.forEach(System.out::println);
        Assert.assertEquals(INDEX_OF_FIRST, employees.get(INDEX_OF_FIRST).getSalary(), DELTA);
    }

    @Test
    public void givenEmployees_firstInSortedLargeFirstIs1() {
        employees.sort(Comparators.employeeComparatorLargestSalaryFirst);
        employees.forEach(System.out::println);
        Assert.assertEquals(LARGEST_SALARY, employees.get(INDEX_OF_FIRST).getSalary(), DELTA);
    }

    @Test public void givenEmployees_findHighestSalary() {
        Employee largestSalary=employees.stream()
                .max(Comparators.employeeComparatorLowestSalaryFirst)
                .orElseThrow(NoSuchElementException::new);

        Assert.assertEquals(LARGEST_SALARY, largestSalary.getSalary(), DELTA);
    }


}
