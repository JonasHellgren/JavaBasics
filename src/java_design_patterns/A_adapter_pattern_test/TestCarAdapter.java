package java_design_patterns.A_adapter_pattern_test;

import java_design_patterns.A_adapter_pattern.ex_movable.*;
import org.junit.Assert;
import org.junit.Test;

public class TestCarAdapter {

    @Test
    public void whenConvertingMPHToKMPH_thenSuccessfullyConverted() {
        CarUsInterface fordMustang = new FordMustang();
        EuCarAdapterInterface adapter = new UsEUCarAdapter(fordMustang);

        Assert.assertEquals(adapter.getTopSpeed(), 431.30312, 0.00001);
    }

    @Test
    public void whenConvertingInchToMeter_thenSuccessfullyConverted() {
        CarUsInterface fordMustang = new FordMustang();
        EuCarAdapterInterface adapter = new UsEUCarAdapter(fordMustang);

        Assert.assertEquals(adapter.getLength(), 4.79, 0.01);
    }


}
