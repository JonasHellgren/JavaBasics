package pluralsight_courses.implementing_design_patterns_using_java_lambda.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pluralsight_courses.implementing_design_patterns_using_java_lambda.models.Employee;
import pluralsight_courses.implementing_design_patterns_using_java_lambda.predicate.Predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestPredicates {

    List<Employee> employees;

    @Before
    public void init() {
        employees= Arrays.asList(
                new Employee("Jonas",60_000),
                new Employee("Katja",40_000),
                new Employee("Alex",0)
        );
    }


    @Test
    public void whenStringIsJonas_thenStringNotNullOrEmpty() {
        String name="Jonas";
        Assert.assertTrue(Predicates.stringNotNullOrEmptyPredicate.test(name));
    }


    @Test
    public void whenStringIsEmpty_thenStringNotNullOrEmptyIsFalse() {
        String name="";
        Assert.assertFalse(Predicates.stringNotNullOrEmptyPredicate.test(name));
    }

    @Test
    public void whenStringIsNull_thenStringNotNullOrEmptyIsFalse() {
        String name=null;
        Assert.assertFalse(Predicates.stringNotNullOrEmptyPredicate.test(name));
    }

    @Test
    public void whenStringIsNull_thenStringNullOrEmptyIsTrue() {
        String name=null;
        Assert.assertTrue(Predicates.stringIsNullOrEmpty.test(name));
    }

    @Test
    public void whenStringIsAlex_thenStringNotNullOrEmptyAndShorterThan5() {
        String name="Alex";
        Predicate<String> pComb=Predicates.stringNotNullOrEmptyPredicate.and(Predicates.stringIsShorterThan5);
        Assert.assertTrue(pComb.test(name));
    }

    @Test public void giveEmployee_whenAnyShortName_thenTrue() {
        boolean anyShortName=employees.stream().anyMatch(Predicates.employeeNameIsShorterThan5);
        System.out.println("anyShortName = " + anyShortName);
        Assert.assertTrue(anyShortName);
    }

    @Test public void giveEmployee_whenAnyLowSalary_thenTrue() {
        boolean anyLowSalary=employees.stream().anyMatch(Predicates.employeeSalaryLowerThan20k);
        System.out.println("anyLowSalary = " + anyLowSalary);
        Assert.assertTrue(anyLowSalary);
    }

    @Test public void giveEmployee_whenLongNameAndAnyLowSalary_thenFalse() {
        boolean anyLongNameAndLowSalary=employees.stream().anyMatch(
                Predicates.employeeNameIsNotShorterThan5.and(Predicates.employeeSalaryLowerThan20k));
        System.out.println("anyLongNameAndLowSalary = " + anyLongNameAndLowSalary);
        Assert.assertFalse(anyLongNameAndLowSalary);
    }



}
