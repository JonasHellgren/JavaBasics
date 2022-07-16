package effective_java.J_exceptions_tests.examples;
import effective_java.J_exceptions.examples.IndexOutOfBoundsExceptionExtended;
import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class TestArrayIndexOutOfBoundsExceptionExtended {

    @Test(expected = Test.None.class)
    public void okIndexingNoException() {
        int[] myArray = new int[7];
        myArray[0] = 1254;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void badIndexGivesException() {
        int[] myArray = new int[7];
        myArray[10] = 1254;
    }

    @Test(expected = Test.None.class)
    public void badIndexGivesNoExceptionWithTryCatch() {
        int[] myArray = new int[7];
        try {
            putNumIntoArray(myArray,10,100);
        } catch (IndexOutOfBoundsExceptionExtended e) {
            log.warning(e.toString());
        }
    }

    @Test(expected = Test.None.class)
    public void badIndexGivesNoExceptionWithTryCatchShorterPutNum() {
        int[] myArray = new int[7];
        try {
            putNumIntoArrayShorter(myArray,10,100);
        } catch (IndexOutOfBoundsExceptionExtended e) {
            log.warning(e.toString());
        }
    }

    private void putNumIntoArray(int[] arr, int idx, int value ) throws IndexOutOfBoundsExceptionExtended {
        if (idx >= 0 && idx < arr.length) {
            arr[idx]=value;
        } else {
            throw new IndexOutOfBoundsExceptionExtended(0,arr.length,idx);
        }
    }

    private void putNumIntoArrayShorter(int[] arr, int idx, int value ) throws IndexOutOfBoundsExceptionExtended {
        try {
            arr[idx]=value;
        } catch (Exception e) {
            throw new IndexOutOfBoundsExceptionExtended(0,arr.length,idx);
        }
    }

}


