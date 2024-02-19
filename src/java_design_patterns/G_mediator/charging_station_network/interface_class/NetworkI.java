package java_design_patterns.G_mediator.charging_station_network.interface_class;

import java_design_patterns.G_mediator.charging_station_network.other.Informer;

public interface NetworkI {
    double calcDeltaSocPerSlot();
    Informer getInformer();
}
