package java_design_patterns.K_abstract_factory.car;

import java_design_patterns.J_factory.car.CarType;

public class SmallCar extends CarAbstractWithLocation {

    public static final CarType SMALL = CarType.SMALL;

    public SmallCar(Location location) {
        super(SMALL, location);
        construct(SMALL, location);
    }

    @Override
    protected void construct(CarType model, Location location) {
        System.out.println(this);
        //add accessories
    }
}
