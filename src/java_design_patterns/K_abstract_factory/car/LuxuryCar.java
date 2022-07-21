package java_design_patterns.K_abstract_factory.car;

import java_design_patterns.J_factory.car.CarType;

public class LuxuryCar extends CarAbstractWithLocation {

    public static final CarType LUXURY = CarType.LUXURY;

    public LuxuryCar(Location location) {
        super(LUXURY, location);
        construct(LUXURY, location);
    }

    @Override
    protected void construct(CarType model, Location location) {
        System.out.println(this);
        //add accessories
    }
}
