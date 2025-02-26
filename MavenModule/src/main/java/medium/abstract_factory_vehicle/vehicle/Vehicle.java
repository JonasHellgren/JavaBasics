package medium.abstract_factory_vehicle.vehicle;

import medium.abstract_factory_vehicle.interf.EngineI;
import medium.abstract_factory_vehicle.interf.WheelI;
import medium.abstract_factory_vehicle.parts.Seat;


/**
 * Seat is not interface
 */

public record Vehicle(WheelI wheel, EngineI engine, Seat seat) {



    @Override
    public String toString() {
        return "Vehicle{" +
                "wheel type=" + wheel.getType() +
                ", wheel diameterInMeters=" + wheel.getDiameterInMeters() +
                ", engine hp=" + engine.getHorsePower() +
                '}';
    }


}
