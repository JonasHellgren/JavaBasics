package mobilapp_java_receipes.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class TestSetComparison {

    @Test
    public void testEqualsContains() {
        var first = new HashSet<>(Arrays.asList(1, 2));
        var second = new HashSet<>(Arrays.asList(1, 2));
        var third = new HashSet<>(Arrays.asList(1, 2, 3));

        var isEqual = first.equals(second);
        var isIntersects = second.stream().anyMatch(i -> third.contains(i));
        var isThirdSubset = first.containsAll(third);

        Assert.assertTrue(isEqual);
        Assert.assertTrue(isIntersects);
        Assert.assertFalse(isThirdSubset);

    }


    @Test
    public void testAddAllRemoveAllAndRetains () {


        var first = new HashSet<>(Arrays.asList(1, 2, 3));
        var second = new HashSet<>(Arrays.asList(3, 4, 5));

        first.addAll(second);
        Assert.assertEquals(5, first.size());

        first.removeAll(second);
        Assert.assertEquals(2, first.size());

        //retainAll gives intersection between two sets
        second.retainAll(new HashSet<>(Arrays.asList(3,4)));
        Assert.assertEquals(new HashSet<>(Arrays.asList(3,4)), second);


    }

}
