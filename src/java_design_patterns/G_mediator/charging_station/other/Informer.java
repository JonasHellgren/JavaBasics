package java_design_patterns.G_mediator.charging_station.other;

import java_design_patterns.G_mediator.charging_station.mediator_parts.ChargingSlot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;
import java.util.Queue;

@AllArgsConstructor
@Getter
public class Informer {

    List<ChargingSlot> slots;
    Queue<Vehicle> vehiclesInQueu;
    double deltaSoCDepotMax;

    public int nOccupiedSlots() {
        return (int) slots.stream().filter(ChargingSlot::isOccupied).count();
    }

    public boolean isAllSlotsOccupied() {
        return nOccupiedSlots() >= slots.size();
    }

    public List<Double> getSocs() {
    return slots.stream()
            .filter(ChargingSlot::isOccupied).map(slot -> slot.getOccupVehicle().getSoc()).toList();
    }

    public int nofSlots() {
        return slots.size();
    }

    public int nofVehiclesInQueue() {
        return vehiclesInQueu.size();
    }


}
