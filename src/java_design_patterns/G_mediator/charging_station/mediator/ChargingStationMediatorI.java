package java_design_patterns.G_mediator.charging_station.mediator;

import java_design_patterns.G_mediator.charging_station.other.Informer;
import java_design_patterns.G_mediator.charging_station.other.Vehicle;

public interface ChargingStationMediatorI {
    void addArrivedVehicle(Vehicle vehicle);
    double calcDeltaSocPerSlot();
    void chargeVehicles();
    void releaseChargedVehiclesAndAddFromQueue();
    Informer getInformer();
}
