package pluralsight_courses.implementing_design_patterns_using_java_lambda.test;

import org.junit.Assert;
import org.junit.Test;
import pluralsight_courses.implementing_design_patterns_using_java_lambda.consumer.Consumers;

import java.util.Arrays;
import java.util.List;

public class TestConsumers {

    @Test
    public void printer() {
        Consumers.print.accept("Hello world");
    }

    @Test
    public void printLowercase() {
        Consumers.printLowerCase.accept("Hello world");
    }

    @Test
    public void modifyListItemsWithTwo() {
        List<Integer> list= Arrays.asList(1,2,3);
        Consumers.modifyMultiplyWithTwo.accept(list);
        Consumers.showList.accept(list);
        Assert.assertTrue(list.containsAll(Arrays.asList(2,4,6)));
    }

    @Test
    public void andThen() {
        List<Integer> list= Arrays.asList(1,2,3);
        Consumers.modifyMultiplyWithTwo.andThen(Consumers.showList).accept(list);
        Assert.assertTrue(list.containsAll(Arrays.asList(2,4,6)));
    }

    @Test
    public void minusOneAndThenMult2() {
        List<Integer> list= Arrays.asList(1,2,3);
        Consumers.modifySubtractWithOne.andThen(Consumers.modifyMultiplyWithTwo).accept(list);
        Consumers.showList.accept(list);
        Assert.assertTrue(list.containsAll(Arrays.asList(0,2,4)));
    }


}
