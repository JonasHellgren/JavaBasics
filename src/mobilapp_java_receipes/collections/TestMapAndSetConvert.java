package mobilapp_java_receipes.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class TestMapAndSetConvert {

    @Test
    public void whenMapValuesToUpperCase() {
        var map = new HashMap<Integer, String>() {{
            put(1, "one");
            put(2, "two");
        }};

        var oddMap = map.entrySet().stream()
                .collect(Collectors.toMap(x -> x.getKey(),
                        x -> x.getValue().toUpperCase()));

        System.out.println("oddMap.values() = " + oddMap.values());

        Assert.assertTrue(oddMap.containsValue("ONE"));

    }

    @Test
    public void whenSetValuesDoubled() {
        var set = new HashSet<>(
                Arrays.asList(1, 2, 3));

        var set3 = set.stream()
                .map(i -> i * 2)
                .collect(Collectors.toSet());

        System.out.println("set3 = " + set3);

        Assert.assertTrue(set3.contains(6));

    }

}
