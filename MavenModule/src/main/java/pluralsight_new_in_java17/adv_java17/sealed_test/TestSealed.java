package pluralsight_new_in_java17.adv_java17.sealed_test;

import org.junit.Test;
import pluralsight_new_in_java17.adv_java17.sealed.Car;
import pluralsight_new_in_java17.adv_java17.sealed.MotorCycle;
import pluralsight_new_in_java17.adv_java17.sealed.Truck;
import pluralsight_new_in_java17.adv_java17.sealed.Vehicle;
import static org.junit.Assert.assertEquals;

/**
 * https://www.baeldung.com/java-sealed-classes-interfaces
 */

public class TestSealed {

    @Test
    public void givenCar_thenCorrectCapacity() {
        Vehicle car=new Car("ABC123",5);
        assertEquals(5,getCapacity(car));
    }

    @Test
    public void givenTruck_thenCorrectCapacity() {
        Vehicle truck=new Truck("ABC123",20_000);
        assertEquals(20_000,getCapacity(truck));
    }

    @Test
    public void givenMC_thenOneSeat() {
        Vehicle mc=new MotorCycle("ABC123");
        assertEquals(1,mc.getNofSeats());
    }

    /**
     * Not using sealed would require casting in following code
     */

    public int getCapacity(Vehicle vehicle) {
        if (vehicle instanceof Car car) {
            return car.getNofSeats();
        } else if (vehicle instanceof Truck truck) {
            return truck.getLoadingCapacity();
        } else {
            throw new RuntimeException("Unknown instance of Vehicle");
        }
    }

}
