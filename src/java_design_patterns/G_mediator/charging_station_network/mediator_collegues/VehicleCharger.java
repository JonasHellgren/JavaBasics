package java_design_patterns.G_mediator.charging_station_network.mediator_collegues;

import java_design_patterns.G_mediator.charging_station_network.interface_class.NetworkI;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicleCharger {
    NetworkI network;

    public void chargeVehicles() {
        double deltaSoc = network.calcDeltaSocPerSlot();
        network.getInformer().getSlots().forEach((s) -> s.chargeVehicle(deltaSoc));
    }


}
