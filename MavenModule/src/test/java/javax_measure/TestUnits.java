package javax_measure;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.unit.MetricPrefix;
import javax.measure.UnitConverter;
import static tec.units.ri.unit.Units.*;
import static tec.units.ri.unit.Units.SECOND;

//https://www.baeldung.com/javax-measure
public class TestUnits {

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

        System.out.println("MetricPrefix.KILO(WATT) = " + MetricPrefix.KILO(WATT));

        assertEquals(SimpleUnitFormat.getInstance().parse("kW"), MetricPrefix.KILO(WATT));
        assertEquals(SimpleUnitFormat.getInstance().parse("ms"), SECOND.divide(1000));

    }
}
