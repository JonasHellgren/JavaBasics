package java_design_patterns.K_abstract_factory_test;

import java_design_patterns.J_factory.car.CarType;
import java_design_patterns.K_abstract_factory.car.*;
import org.junit.Assert;
import org.junit.Test;

public class TestAbstractCarFactory {


    @Test
    public void testSmallCarFromUSA() {
        CarAbstractWithLocation car= CarFactoryUS.buildCar(CarType.SMALL);
        Assert.assertTrue(car instanceof SmallCar);
    }


    @Test
    public void testSedanCarFromAsia() {
        CarAbstractWithLocation car= CarFactoryAsia.buildCar(CarType.SEDAN);
        Assert.assertTrue(car instanceof SedanCar);
    }
}
