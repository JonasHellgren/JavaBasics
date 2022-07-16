package effective_java.J_exceptions_tests.examples;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

@Log
public class TestDivision {


    public static final int RESULT_WHEN_EXCEPTION = 0;

    @Test
    public void divOneGivesNoException() {
        int i = 12, d = 1;
        int result = getResult(i, d);
        System.out.println("result = " + result);
        Assert.assertEquals(12,result);
    }

    @Test
    public void divZeroGivesCatchedException() {
        int i = 12, d = 0;
        int result = getResult(i, d);
        System.out.println("result = " + result);
        Assert.assertEquals(RESULT_WHEN_EXCEPTION,result);
    }

    private int getResult(int i, int d) {
        int result = -1;

        try {
            result = i / d;
        } catch (ArithmeticException e) {
            result = RESULT_WHEN_EXCEPTION;
            log.warning(e.getMessage());
            e.printStackTrace();  //useful during dev
        } catch (Exception e) {
            result = RESULT_WHEN_EXCEPTION;
            e.printStackTrace();
        }
        return result;
    }
}
