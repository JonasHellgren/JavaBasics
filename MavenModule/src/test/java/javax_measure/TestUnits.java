package javax_measure;

import org.junit.Assert;
import org.junit.Test;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.unit.MetricPrefix;

import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Pressure;

import static org.junit.Assert.assertTrue;
import static tec.units.ri.unit.Units.*;
import static tec.units.ri.unit.Units.SECOND;

public class TestUnits {

    @Test
    public void givenUnit_whenAlternateUnit_ThenGetAlternateUnit() {
        Unit<Pressure> PASCAL = NEWTON.divide(METRE.pow(2))
                .alternate("Pa").asType(Pressure.class);
        Assert.assertTrue(SimpleUnitFormat.getInstance().parse("Pa")
                .equals(PASCAL));
    }

    @Test
    public void givenMeters_whenConvertToKilometer_ThenConverted() {
        double distanceInMeters = 50.0;
        UnitConverter metreToKilometre = METRE.getConverterTo(MetricPrefix.KILO(METRE));
        double distanceInKilometers = metreToKilometre.convert(distanceInMeters );
        Assert.assertEquals(0.05, distanceInKilometers, 0.00f);
    }

    @Test
    public void givenMetersPerSecond_whenConvertToKilometerPerHour_ThenConverted() {
        double speedInMeterPerSec = 10.0;
        UnitConverter speedConverterMeterPerSecToKph = METRE_PER_SECOND.getConverterTo(KILOMETRE_PER_HOUR);
        double speedKph = speedConverterMeterPerSecToKph.convert(speedInMeterPerSec );
        Assert.assertEquals(36, speedKph, 0.1d);
    }

    @Test
    public void givenSymbol_WhenCompareToSystemUnit_ThenSuccess() {
        assertTrue(SimpleUnitFormat.getInstance().parse("kW")
                .equals(MetricPrefix.KILO(WATT)));
        assertTrue(SimpleUnitFormat.getInstance().parse("ms")
                .equals(SECOND.divide(1000)));
    }
}
