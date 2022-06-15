package packt_Java_coding_problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * The method will search the given key in the given array and will return the corresponding index or a negative value
 */


public class TestBinaryFLightSearch {

    int[] array=new int[]{1,2,3,4,5,6};

    @Test
    public void TestSearch() {
        int index = Arrays.binarySearch(array, 4);
        Assert.assertEquals(3,index);
        System.out.println("index:"+index);
    }


    @Test
    public void TestNotPresent() {
        int index = Arrays.binarySearch(array, 7);
        Assert.assertTrue(index<0);
        System.out.println("index:"+index);
    }

}
