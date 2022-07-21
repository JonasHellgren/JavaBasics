package java_design_patterns.J_factory.car;

public class LuxuryCar extends CarAbstract {

    LuxuryCar() {
        super(CarType.LUXURY);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building luxury car");
        // add accessories
    }

}