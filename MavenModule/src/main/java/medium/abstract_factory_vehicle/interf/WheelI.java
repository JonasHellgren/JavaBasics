package medium.abstract_factory_vehicle.interf;

import medium.abstract_factory_vehicle.enums.VehicleType;

public  interface WheelI {
    VehicleType getType();
    double getDiameterInMeters();


}