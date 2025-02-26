package medium.abstract_factory_vehicle;


import medium.abstract_factory_vehicle.concrete_factory.CarFactory;
import medium.abstract_factory_vehicle.concrete_factory.TruckFactory;
import medium.abstract_factory_vehicle.enums.VehicleType;
import medium.abstract_factory_vehicle.interf.VehicleFactoryI;
import medium.abstract_factory_vehicle.vehicle.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestVehicleFactory {

    VehicleFactoryI truckFactory, carFactory;

    @BeforeEach
    public void init() {
        truckFactory = new TruckFactory();
        carFactory = new CarFactory();
    }

    @Test
    void whenCreateTruck_thenCorrect() {
        Vehicle vehicle = truckFactory.create();
        System.out.println(vehicle);

        Assertions.assertEquals(VehicleType.TRUCK, vehicle.wheel().getType());
        Assertions.assertEquals(VehicleType.TRUCK, vehicle.seat().getType());
        Assertions.assertEquals(1.5, vehicle.wheel().getDiameterInMeters());
    }

    @Test
    void whenCreateCar_thenCorrect() {
        Vehicle vehicle = carFactory.create();
        System.out.println(vehicle);

        Assertions.assertEquals(VehicleType.CAR, vehicle.wheel().getType());
        Assertions.assertEquals(VehicleType.CAR, vehicle.seat().getType());
        Assertions.assertEquals(0.7, vehicle.wheel().getDiameterInMeters());
    }


}
