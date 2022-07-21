package java_design_patterns.J_factory.car;

public class CarFactory {

    public static CarAbstract buildCar(CarType carType) {

        switch (carType) {
            case SMALL:
                return new SmallCar();
            case SEDAN:
                return new SedanCar();
            case LUXURY:
                return new LuxuryCar();
            default:
                throw new IllegalArgumentException();
        }
    }
}

