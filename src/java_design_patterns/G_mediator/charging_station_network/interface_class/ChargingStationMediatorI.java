package java_design_patterns.G_mediator.charging_station_network.interface_class;

import java_design_patterns.G_mediator.charging_station_network.helper.VehicleMover;
import java_design_patterns.G_mediator.charging_station_network.other.Informer;
import java_design_patterns.G_mediator.charging_station_network.other.Vehicle;

public interface ChargingStationMediatorI {
  //  void addArrivedVehicle(Vehicle vehicle);
    double calcDeltaSocPerSlot();
 //   void chargeVehicles();
 //   void releaseChargedVehiclesAndAddFromQueue();
    Informer getInformer();
}
