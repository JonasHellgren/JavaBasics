package java_design_patterns.G_mediator.charging_station_network.network;

import java_design_patterns.G_mediator.charging_station_network.interface_class.ChargingStationMediatorI;
import java_design_patterns.G_mediator.charging_station_network.other.Informer;
import java_design_patterns.G_mediator.charging_station_network.station.ChargingStation;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;


@Log
@AllArgsConstructor
public class Network implements ChargingStationMediatorI {

   // Informer informer;
    ChargingStation station;

    @Override
    public double calcDeltaSocPerSlot() {
        return station.getInformer().getPowerSplitter().deltaSocPerSlot();
    }

    @Override
    public Informer getInformer() {
        return station.getInformer();
    }


}
