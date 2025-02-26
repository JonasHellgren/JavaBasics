package medium.abstract_factory_vehicle.parts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import medium.abstract_factory_vehicle.enums.VehicleType;

@Getter
@AllArgsConstructor
public class Seat  {
    VehicleType type;
}
