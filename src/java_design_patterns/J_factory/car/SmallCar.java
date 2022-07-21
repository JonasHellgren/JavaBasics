package java_design_patterns.J_factory.car;

public class SmallCar  extends CarAbstract {

    SmallCar() {
        super(CarType.SMALL);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building small car");
        // add accessories
    }
}
