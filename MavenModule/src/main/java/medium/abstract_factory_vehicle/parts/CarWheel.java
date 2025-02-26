package medium.abstract_factory_vehicle.parts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import medium.abstract_factory_vehicle.enums.VehicleType;
import medium.abstract_factory_vehicle.interf.WheelI;

@Getter
@AllArgsConstructor
public class CarWheel implements WheelI {

    final VehicleType type = VehicleType.CAR;
    String name;
    double diameterInMeters;

}