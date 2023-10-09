package mobilapp_java_receipes.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestGrouping {

    @Test
    public void whenGrouping() {
        Integer[] numbers = { 1, 2, 3, 4, 5 };

        Map<String, List<Integer>> map = Arrays.stream(numbers)
                .collect(Collectors.groupingBy(
                        x -> x % 2 == 0 ? "even" : "odd"));

        System.out.println("map = " + map);

    }
}
