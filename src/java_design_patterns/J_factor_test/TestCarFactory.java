package java_design_patterns.J_factor_test;

import java_design_patterns.J_factory.car.*;
import org.junit.Assert;
import org.junit.Test;

public class TestCarFactory {

    @Test
    public void testBuildCarSmall() {
        CarAbstract car=CarFactory.buildCar(CarType.SMALL);
        Assert.assertTrue(car instanceof SmallCar);
    }


    @Test
    public void testBuildCarSedan() {
        CarAbstract car=CarFactory.buildCar(CarType.SEDAN);
        Assert.assertTrue(car instanceof SedanCar);
    }

}
