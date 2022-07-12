package effective_java.E_generics_tests.item31;

import effective_java.E_generics.item31.WildListOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestWildListOperator {

    public static final double DELTA = 0.1;
    public static final double SUM_LIST2 = 15.3;
    public static final double SUM_LIST1 = 22d;


    @Test
    public void testSumNumberSubClass() {
        // Lists in this test are upper bounded to Number, list members are sub class of Number
        List<Integer> list1 = Arrays.asList(4, 5, 6, 7);
        List<Double> list2 = Arrays.asList(4.1, 5.1, 6.1);

        // printing
        System.out.println("Total sum is:" + WildListOperator.sumNumberSubClass(list1));
        System.out.print("Total sum is:" + WildListOperator.sumNumberSubClass(list2));

        //assertions
        Assert.assertEquals(SUM_LIST1,WildListOperator.sumNumberSubClass(list1),DELTA);
        Assert.assertEquals(SUM_LIST2,WildListOperator.sumNumberSubClass(list2),DELTA);

    }

    @Test
    public void testSumIntegerSuperClass() {
        // Lists in this test are lower bounded to Integer, list members are super class of Integer
        List<Integer> list1 = Arrays.asList(4, 5, 6, 7);
        List<Number> list2 = Arrays.asList(4.1, 5.1, 6.1);

        // printing
        System.out.println("Total sum is:" + WildListOperator.sumIntegerSuperClass(list1));
        System.out.println("Total sum is:" + WildListOperator.sumIntegerSuperClass(list2));

        //assertions
        Assert.assertEquals(SUM_LIST1,WildListOperator.sumIntegerSuperClass(list1),DELTA);
        Assert.assertEquals(SUM_LIST2,WildListOperator.sumIntegerSuperClass(list2),DELTA);
    }

    @Test
    public void testSumUnBounded() {
        // Lists in this test are lower unbounded to Integer, list members are any class
        List<Integer> list1 = Arrays.asList(4, 5, 6, 7);
        List<Number> list2 = Arrays.asList(4.1, 5.1, 6.1);

        // printing
        System.out.println("Total sum is:" + WildListOperator.sumUnBounded(list1));
        System.out.println("Total sum is:" + WildListOperator.sumUnBounded(list2));

        //assertions
        Assert.assertEquals(SUM_LIST1,WildListOperator.sumUnBounded(list1), DELTA);
        Assert.assertEquals(SUM_LIST2,WildListOperator.sumUnBounded(list2),DELTA);
    }

}
