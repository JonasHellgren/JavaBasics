package effective_java.F_enums_and_annotaitons_tests.item34;

import effective_java.F_enums_and_annotaitons.item34.Planet;
import org.junit.Test;


/**
 * https://dev.to/kylec32/effective-java-use-enums-instead-of-int-constants-5de3
 */

public class TestPlanet {

    @Test
    public void test() {
        double earthWeight = 90d;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.println("Weight on "+p+" is "+ p.surfaceWeight(mass) );
        }
    }

    @Test
    public void testRadius() {
        for (Planet p : Planet.values()) {
            System.out.println("Radius on "+p+" is "+ p.radius()/1000+" km" );
        }
    }

    @Test
    public void testMercury() {
        System.out.println("Planet.MERCURY = " + Planet.MERCURY);
        System.out.println("Planet.MERCURY.mass() = " + Planet.MERCURY.mass());
    }

}
