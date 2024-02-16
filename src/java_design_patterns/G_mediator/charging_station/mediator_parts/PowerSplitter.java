package java_design_patterns.G_mediator.charging_station.mediator_parts;

import java_design_patterns.G_mediator.charging_station.mediator.ChargingStationMediatorI;
import java_design_patterns.G_mediator.charging_station.other.Informer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PowerSplitter {
    ChargingStationMediatorI mediator;

    public double deltaSocPerSlot() {
        Informer informer = mediator.getInformer();
        return informer.getDeltaSoCDepotMax() /Math.max(1, informer.nOccupiedSlots());
    }


}
