package java_design_patterns.G_mediator.charging_station.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Vehicle {
    String id;
    double soc;

    public Vehicle createVehicleWithZeroSoC(String id) {
        return new Vehicle(id,0d);
    }

    public void  charge(double deltaSoc) {
        this.soc+=deltaSoc;
    }

}
