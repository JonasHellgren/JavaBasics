package java_design_patterns.D_bridge_test;

import java_design_patterns.D_bridge.vehicle_production.*;
import org.junit.Test;

public class TestVehicleProduction {

    @Test
    public void test() {
        Vehicle bike = new Bike();
        bike.joinWorkshop(new AssembleWorkShop());
        bike.manufacture();

        Vehicle car = new Car();
        car.joinWorkshop(new ProduceWorkShop());
        car.joinWorkshop(new AssembleWorkShop());
        car.joinWorkshop(new TestWorkShop());
        car.manufacture();
    }
}
