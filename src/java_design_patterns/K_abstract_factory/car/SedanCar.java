
package java_design_patterns.K_abstract_factory.car;

import java_design_patterns.J_factory.car.CarType;

public class SedanCar extends CarAbstractWithLocation {

    public static final CarType SEDAN = CarType.SEDAN;

    public SedanCar(Location location) {
        super(SEDAN, location);
        construct(SEDAN, location);
    }

    @Override
    protected void construct(CarType model, Location location) {
        System.out.println(this);
        //add accessories
    }
}
