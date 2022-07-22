package java_design_patterns.P_strategy_test;

import java_design_patterns.P_strategy.math.Add;
import java_design_patterns.P_strategy.math.Context;
import java_design_patterns.P_strategy.math.Multiply;
import java_design_patterns.P_strategy.math.Subtract;
import org.junit.Assert;
import org.junit.Test;

public class TestMath {

    @Test
    public void test() {
        Context context = new Context(new Add());
        Assert.assertEquals(15, context.executeStrategy(10, 5));

        context = new Context(new Subtract());
        Assert.assertEquals(5, context.executeStrategy(10, 5));

        context = new Context(new Multiply());
        Assert.assertEquals(50, context.executeStrategy(10, 5));
    }
}
