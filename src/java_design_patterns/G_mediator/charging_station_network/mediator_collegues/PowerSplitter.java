package java_design_patterns.G_mediator.charging_station_network.mediator_collegues;

import java_design_patterns.G_mediator.charging_station_network.interface_class.ChargingStationMediatorI;
import java_design_patterns.G_mediator.charging_station_network.other.Informer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PowerSplitter {
    ChargingStationMediatorI mediator;

    public double deltaSocPerSlot() {
        Informer informer = mediator.getInformer();
        return informer.getDeltaSoCDepotMax()/Math.max(1, informer.nOccupiedSlots());
    }


}
