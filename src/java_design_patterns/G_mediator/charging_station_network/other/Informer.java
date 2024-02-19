package java_design_patterns.G_mediator.charging_station_network.other;

import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.VehicleCharger;
import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.VehicleMover;
import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.ChargingSlot;
import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.PowerSplitter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Queue;

@AllArgsConstructor
@Getter
public class Informer {

    List<ChargingSlot> slots;
    Queue<Vehicle> vehiclesInQueue;
    PowerSplitter powerSplitter;
    VehicleMover mover;
    VehicleCharger charger;
    double deltaSoCDepotMax;

    public int nOccupiedSlots() {
        return (int) slots.stream().filter(ChargingSlot::isOccupied).count();
    }

    public boolean isAllSlotsOccupied() {
        return nOccupiedSlots() >= slots.size();
    }

    public List<Double> getSocs() {
    return slots.stream()
            .filter(ChargingSlot::isOccupied).map(slot -> slot.getVehicle().getSoc()).toList();
    }

    public int nofSlots() {
        return slots.size();
    }

    public int nofVehiclesInQueue() {
        return vehiclesInQueue.size();
    }


}
