package medium.abstract_factory_vehicle.interf;

import medium.abstract_factory_vehicle.parts.Seat;
import medium.abstract_factory_vehicle.vehicle.Vehicle;

public interface VehicleFactoryI {

    default  Vehicle create() {
        return new Vehicle(createWheel(), createEngine(), createSeat());
    }
    WheelI createWheel();
    EngineI createEngine();
    Seat createSeat();
}