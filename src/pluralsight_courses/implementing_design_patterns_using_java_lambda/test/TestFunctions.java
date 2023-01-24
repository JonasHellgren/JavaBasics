package pluralsight_courses.implementing_design_patterns_using_java_lambda.test;

import org.junit.Assert;
import org.junit.Test;
import pluralsight_courses.implementing_design_patterns_using_java_lambda.function.Functions;
import pluralsight_courses.implementing_design_patterns_using_java_lambda.models.Employee;

import java.util.function.Function;

public class TestFunctions {

    @Test
    public void whenJonasToLowerCase_thenjonas() {
        String lowerCaseOnly= Functions.stringToLowerCase.apply("Jonas");
        System.out.println("lowerCaseOnly = " + lowerCaseOnly);
        Assert.assertEquals("jonas",lowerCaseOnly);
    }

    @Test public void whenAddOne_thenIncreased() {
        Assert.assertEquals(1,Functions.addOne.apply(0d),0.1);
    }


    @Test public void whenSummingOneAndOne_thenTwo() {
        Assert.assertEquals(2,Functions.getSum.apply(1d,1d),0.1);
    }

    @Test public void whenSummingOneAndOneAndThenAddOne_thenThree() {
        Assert.assertEquals(3,Functions.getSum.andThen(Functions.addOne).apply(1d,1d),0.1);
    }

    @Test public void whenDoubleSalary_then20k() {
        Employee e=new Employee("Jonas",10_000);
        Assert.assertEquals(20_000,Functions.doubleSalary.apply(e),0.1);
    }

}
