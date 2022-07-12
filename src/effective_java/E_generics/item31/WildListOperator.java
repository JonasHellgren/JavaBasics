package effective_java.E_generics.item31;

import java.util.List;

/***
 * Wildcards are handy when control of parameters in static methods is wanted
 * https://www.geeksforgeeks.org/wildcards-in-java/
 */

public class WildListOperator {

    //list members are sub class of Number
    public static double sumNumberSubClass(List<? extends Number> list)  {
        double sum=0;
        for (Number num:list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    //list members are super class of Integer
    public static double sumIntegerSuperClass(List<? super Integer> list)  {
        double sum=0;
        for (Object num:list) {

            double doubleNum = getDoubleNum(num);
            sum += doubleNum;
        }
        return sum;
    }

    /**
     *  Unbounded Wildcard:
     * This wildcard type is specified using the wildcard character (?), for example, List. This is called a list of unknown types. These are useful in the following cases –
     * When writing a method that can be employed using functionality provided in Object class.
     * When the code is using methods in the generic class that doesn’t depend on the type parameter
     */

    public static double sumUnBounded(List<?> list)  {
        double sum=0;
        for (Object num:list) {
            double doubleNum = getDoubleNum(num);
            sum += doubleNum;
        }
        return sum;
    }


    private static double getDoubleNum(Object num) {
        return (num instanceof Integer)
                ? (Integer) num
                : (Double) num;
    }

}
