package effective_java.I_general_programming_tests.item60;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TestFloatingPoint {

    public static final double SMALL_DOUBLE = 1e-10;

    @Test
    public void testRoundingError() {
        double a=1.03, b=0.42;
        System.out.println(a-b);
        Assert.assertTrue((Math.abs(a-b))> SMALL_DOUBLE);
    }


    @Test
    public void testBigDecimalNoRoundingError() {
        BigDecimal bdFromDoubleA = new BigDecimal("1.03");
        BigDecimal bdFromDoubleB = new BigDecimal("0.42");
        BigDecimal difference = bdFromDoubleA.subtract(bdFromDoubleB);
        System.out.println("difference = " + difference);
        Assert.assertTrue(difference.equals(new BigDecimal("0.61")));

    }


    //we should use the String constructor instead of the double constructor.
    @Test
    public void testBigDecimalRoundingError() {
        BigDecimal bdFromDoubleA = new BigDecimal(1.03d);
        BigDecimal bdFromDoubleB = new BigDecimal(0.42d);
        BigDecimal difference = bdFromDoubleA.subtract(bdFromDoubleB);

        System.out.println(bdFromDoubleA.doubleValue()-bdFromDoubleB.doubleValue());
        System.out.println("difference = " + difference);

        Assert.assertTrue((bdFromDoubleA.doubleValue()-bdFromDoubleB.doubleValue())> SMALL_DOUBLE);
        Assert.assertFalse(difference.equals(new BigDecimal(0.61d)));

    }

    @Test
    public void whenBigDecimalCreatedFromDouble_thenValueMayNotMatch() {
        BigDecimal bdFromDouble = new BigDecimal(0.1d);
        Assert.assertNotEquals("0.1", bdFromDouble.toString());
    }

}
