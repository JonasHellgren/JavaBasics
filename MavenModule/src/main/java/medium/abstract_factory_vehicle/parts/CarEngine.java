package medium.abstract_factory_vehicle.parts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import medium.abstract_factory_vehicle.interf.EngineI;

@Getter
@AllArgsConstructor
public class CarEngine implements EngineI {
    double horsePower;
}