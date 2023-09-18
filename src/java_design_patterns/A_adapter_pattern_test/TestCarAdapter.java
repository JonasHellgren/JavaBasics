package java_design_patterns.A_adapter_pattern_test;

import java_design_patterns.A_adapter_pattern.ex_movable.*;
import org.junit.Assert;
import org.junit.Test;

/***
 * When to Use Adapter Pattern
 * When an outside component provides captivating functionality that we’d like to reuse, but it’s incompatible with our
 * current application. A suitable Adapter can be developed to make them compatible with each other
 *
 * Below CarUsInterface is in US units, and EU interface is using EU units
 */

public class TestCarAdapter {

    @Test
    public void whenConvertingMPHToKMPH_thenSuccessfullyConverted() {
        CarUsInterface fordMustang = new FordMustang();
        EuCarAdapterInterface euAdaptedMustang = new UsEUCarAdapter(fordMustang);

        Assert.assertEquals(euAdaptedMustang.getTopSpeedInKph(), 431.30312, 0.00001);
    }

    @Test
    public void whenConvertingInchToMeter_thenSuccessfullyConverted() {
        CarUsInterface fordMustang = new FordMustang();
        EuCarAdapterInterface euAdaptedMustang = new UsEUCarAdapter(fordMustang);

        Assert.assertEquals(euAdaptedMustang.getLengthInMeter(), 4.79, 0.01);
    }


}
