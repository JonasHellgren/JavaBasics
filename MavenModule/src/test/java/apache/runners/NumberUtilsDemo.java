package apache.runners;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class NumberUtilsDemo {
    public static void main(String[] args) {
        // Convert a String to an int, with a default value if the conversion fails
        int num = NumberUtils.toInt("100", 0);
        System.out.println("Number: " + num);

        // Convert a String to an int, with a default value if the conversion fails
        double doubleNum = NumberUtils.toDouble("100.001", 0);
        System.out.println("doubleNum: " + doubleNum);

        // Finding the max of a series of numbers
        System.out.println("Max: " + NumberUtils.max(new int[]{1, 3, 2}));

        double value = 8.123456;
        BigDecimal scaledValue = NumberUtils.toScaledBigDecimal(value, 3, RoundingMode.HALF_UP);

        System.out.println("Original Value: " + value);
        System.out.println("Scaled Value: " + scaledValue);

        double val=NumberUtils.toDouble(scaledValue);
        System.out.println("val = " + val);

        double zero= NumberUtils.DOUBLE_ZERO;
        System.out.println("zero = " + zero);


    }
}