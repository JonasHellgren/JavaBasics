package medium.abstract_factory_vehicle.concrete_factory;

import medium.abstract_factory_vehicle.enums.VehicleType;
import medium.abstract_factory_vehicle.interf.EngineI;
import medium.abstract_factory_vehicle.interf.VehicleFactoryI;
import medium.abstract_factory_vehicle.interf.WheelI;
import medium.abstract_factory_vehicle.parts.CarEngine;
import medium.abstract_factory_vehicle.parts.CarWheel;
import medium.abstract_factory_vehicle.parts.Seat;

public class CarFactory implements VehicleFactoryI {

    public WheelI createWheel() {
        return new CarWheel("Michelin",0.7);
    }

    public EngineI createEngine() {
        return new CarEngine(150);
    }

    public Seat createSeat() {
        return new Seat(VehicleType.CAR);
    }



}