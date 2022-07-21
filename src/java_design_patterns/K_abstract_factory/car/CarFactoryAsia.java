package java_design_patterns.K_abstract_factory.car;

import java_design_patterns.J_factory.car.*;

public class CarFactoryAsia {

    public static CarAbstractWithLocation buildCar(CarType carType) {

        Location location=Location.ASIA;

        switch (carType) {
            case SMALL:
                return new SmallCar(location);
            case SEDAN:
                return new SedanCar(location);
            case LUXURY:
                return new LuxuryCar(location);
            default:
                throw new IllegalArgumentException();
        }
    }
}

