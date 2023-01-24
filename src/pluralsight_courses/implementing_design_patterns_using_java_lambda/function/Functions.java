package pluralsight_courses.implementing_design_patterns_using_java_lambda.function;

import pluralsight_courses.implementing_design_patterns_using_java_lambda.models.Employee;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functions {

    public static Function<String,String> stringToLowerCase = a -> a.toLowerCase();

    public static Function<Double,Double> addOne = a -> a+1;

    public static BiFunction<Double,Double,Double> getSum = (a,b) -> a+b;

    public static Function<Employee,Double> doubleSalary = e -> e.getSalary()*2;
}
