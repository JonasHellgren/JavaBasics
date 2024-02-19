package java_design_patterns.G_mediator.charging_station_network.helper;

import java_design_patterns.G_mediator.charging_station_network.network.Network;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicleCharger {
    Network network;

    public void chargeVehicles() {
        network.getInformer().getSlots().forEach((s) -> s.chargeVehicle());
    }


}
