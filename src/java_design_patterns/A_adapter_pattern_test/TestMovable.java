package java_design_patterns.A_adapter_pattern_test;

import java_design_patterns.A_adapter_pattern.ex_movable.BugattiVeyron;
import java_design_patterns.A_adapter_pattern.ex_movable.Movable;
import java_design_patterns.A_adapter_pattern.ex_movable.MovableAdapter;
import java_design_patterns.A_adapter_pattern.ex_movable.MovableAdapterImpl;
import org.junit.Assert;
import org.junit.Test;

public class TestMovable {

    @Test
    public void whenConvertingMPHToKMPH_thenSuccessfullyConverted() {
        Movable bugattiVeyron = new BugattiVeyron();
        MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);

        Assert.assertEquals(bugattiVeyronAdapter.getTopSpeed(), 431.30312, 0.00001);
    }

}
