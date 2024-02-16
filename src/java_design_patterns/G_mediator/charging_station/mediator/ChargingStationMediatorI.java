package java_design_patterns.G_mediator.charging_station.mediator;

import java_design_patterns.G_mediator.charging_station.other.Vehicle;

public interface ChargingStationMediatorI {
    void addArrivedVehicle(Vehicle vehicle);
    void chargeVehicles();
    void releaseChargedVehiclesAndAddFromQueu();
}
