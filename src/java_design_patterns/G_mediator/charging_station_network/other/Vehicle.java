package java_design_patterns.G_mediator.charging_station_network.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Vehicle {
    String id;
    double soc;
    boolean isEmpty;

    public static Vehicle createVehicleWithZeroSoC(String id) {
        return new Vehicle(id, 0d, false);
    }

    public static Vehicle createEmpty() {
        return new Vehicle("", 0, true);
    }

    public void charge(double deltaSoc) {
        this.soc = Math.min(100, soc + deltaSoc);
    }

}
