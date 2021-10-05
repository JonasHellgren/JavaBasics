package packt_Java_coding_problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class TestCheckIndex {


    /**
     * This method is used for checking if the index is within the given length. It returns the index
     * if 0 <= index < length. Otherwise, it throws an IndexOutOfBoundsException as shown below:
     */

    int[] arrayList=new int[] {1,2,3,4,5};

    @Test
    public void givenInfRangeNumber_whenReturnNumber() {
        Assert.assertEquals(3,Objects.checkIndex(3, arrayList.length));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void givenOutOfRangeNumber_whenInvokeCheckIndex_thenException() {
        Objects.checkIndex(5, arrayList.length);
    }

    //checkFromToIndex(fromIndex,toIndex,length) is used to check if the given sub range formed by [fromIndex, toIndex)
    // is within the range formed by [0, length). If true, returns the lower bound as shown below. If not => exception
    // [a, b) indicates the range is inclusive of a and exclusive of b.
    @Test
    public void givenSubRange_whenCheckFromToIndex_thenNumber() {
        Assert.assertEquals(2,(Objects.checkFromToIndex(2,arrayList.length,arrayList.length)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void givenInvalidSubRange_whenCheckFromToIndex_thenException() {
        int length = 6;
        Objects.checkFromToIndex(2,7,length);
    }


}
