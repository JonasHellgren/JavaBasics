package mobilapp_java_receipes.lambdas;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestAllAny {

    @Test
    public void test() {

        Integer[] numbers = {1, 2, 3, 4, 5};
        var list = Arrays.asList(numbers);
        var allLess10 = list.stream().allMatch(i -> i < 10);
        var someMore3 = list.stream().anyMatch(i -> i > 3);
        var allOdd = list.stream().allMatch(i -> i % 2 == 1);

        Assert.assertTrue(allLess10);
        Assert.assertTrue(someMore3);
        Assert.assertFalse(allOdd);

    }
}
