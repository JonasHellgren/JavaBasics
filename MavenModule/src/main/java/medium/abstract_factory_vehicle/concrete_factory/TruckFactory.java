package medium.abstract_factory_vehicle.concrete_factory;

import medium.abstract_factory_vehicle.enums.VehicleType;
import medium.abstract_factory_vehicle.interf.EngineI;
import medium.abstract_factory_vehicle.interf.VehicleFactoryI;
import medium.abstract_factory_vehicle.interf.WheelI;
import medium.abstract_factory_vehicle.parts.Seat;
import medium.abstract_factory_vehicle.parts.TruckEngine;
import medium.abstract_factory_vehicle.parts.TruckWheel;

public class TruckFactory implements VehicleFactoryI {
    public WheelI createWheel() {
        return new TruckWheel("Michelin",1.5);
    }

    public EngineI createEngine() {
        return new TruckEngine(500);
    }

    public Seat createSeat() {
        return new Seat(VehicleType.TRUCK);
    }
}