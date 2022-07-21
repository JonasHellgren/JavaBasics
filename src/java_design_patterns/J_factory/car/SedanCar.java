package java_design_patterns.J_factory.car;

public class SedanCar extends CarAbstract {

    SedanCar() {
        super(CarType.SEDAN);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building sedan car");
        // add accessories
    }
}
