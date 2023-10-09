package mobilapp_java_receipes.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestArrayMethods {

    @Test
    public void whenDiff_thenCorrect() {

        Integer[] ar1 = {1, 2, 3, 4};
        Integer[] ar2 = {1, 2, 3, 4, 5};
        var set1 = new HashSet<>(
                Arrays.asList(ar1));
        var diff = new HashSet<>(
                Arrays.asList(ar2));
        diff.removeAll(set1);

        Assert.assertEquals(1, diff.size());
        Assert.assertTrue(diff.contains(5));

    }


    @Test
    public void whenEqual_thenCorrect() {

        Integer[] ar1 = {1, 2, 3};
        Integer[] ar2 = {1, 2, 3};
        Integer[] ar3 = {1, 2, 4};

        Assert.assertTrue(Arrays.equals(ar1,ar2));
        Assert.assertFalse(Arrays.equals(ar1,ar3));

    }

    @Test
    public void whenCopyOf() {
        int[] ar1 = {1, 2, 3};

        int[] first2 = Arrays.copyOf(ar1, 2);

        int[] last2 = Arrays.copyOfRange(ar1, 1,ar1.length);

        System.out.println("first2 = " + Arrays.toString(first2));
        System.out.println("last2 = " + Arrays.toString(last2));

        Assert.assertArrayEquals(first2, new int[]{1, 2});
        Assert.assertArrayEquals(last2, new int[]{2, 3});

    }


}
