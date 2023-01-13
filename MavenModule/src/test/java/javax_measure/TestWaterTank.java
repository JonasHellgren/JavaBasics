package javax_measure;

import org.junit.Assert;
import org.junit.Test;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.MetricPrefix;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.Volume;

import static org.junit.Assert.assertTrue;

import static tec.units.ri.unit.Units.*;

public class TestWaterTank {

    @Test
    public void givenQuantity_whenGetUnitAndConvertValue_thenSuccess() {
        WaterTank waterTank = new WaterTank();
        waterTank.setCapacityMeasure(Quantities.getQuantity(9.2, LITRE));
        Assert.assertEquals(LITRE, waterTank.getCapacityMeasure().getUnit());

        Quantity<Volume> waterCapacity = waterTank.getCapacityMeasure();
        double volumeInLitre = waterCapacity.getValue().doubleValue();
        Assert.assertEquals(9.2, volumeInLitre, 0.0f);
    }

    @Test public void convertToCubicMeter() {
        WaterTank waterTank = new WaterTank();
        waterTank.setCapacityMeasure(Quantities.getQuantity(1000, LITRE));
        Quantity<Volume> waterCapacity = waterTank.getCapacityMeasure();
        double volumeInCubicMeter = waterCapacity.to(CUBIC_METRE).getValue().doubleValue();
        Assert.assertEquals(1.0, volumeInCubicMeter, 0.0f);
    }




}
