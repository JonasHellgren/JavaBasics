package pluralsight_new_in_java17.playbook;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;

import static org.junit.Assert.assertEquals;

public class TestReplaceAll {

    public static final int NOF_DEC = 2;

    @Test
    public void whenRoundingWithReplaceAll_thenCorrect() {
        List<Double> doubleList = new ArrayList<>(List.of(1.1234, 2.345));

        UnaryOperator<Double> roundToOneDec = n -> BigDecimal.valueOf(n).setScale(NOF_DEC, RoundingMode.DOWN).doubleValue();
        doubleList.replaceAll(roundToOneDec);
        assertEquals(new ArrayList<>(List.of(1.12, 2.34)), doubleList);
    }

    @Test
    public void whenMakingAllPositiveWithReplaceAll_thenCorrect() {
        List<Double> doubleList = new ArrayList<>(List.of(-1d, -2d, 1d, 2d));
        UnaryOperator<Double> abs = n -> Math.abs(n);
        doubleList.replaceAll(abs);
        assertEquals(new ArrayList<>(List.of(1d, 2d, 1d, 2d)), doubleList);

    }

}
