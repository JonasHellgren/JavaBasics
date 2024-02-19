package java_design_patterns.G_mediator.charging_station_network.mediator_collegues;

import java_design_patterns.G_mediator.charging_station_network.interface_class.NetworkI;
import java_design_patterns.G_mediator.charging_station_network.other.Vehicle;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Queue;

import static common.Conditionals.executeIfTrue;

@AllArgsConstructor
@Log
public class VehicleMover {

    NetworkI network;

    public void releaseChargedVehiclesAndAddFromQueue() {
        getSlots().forEach(s -> executeIfTrue(s.isFullyCharged(), () -> releaseAndReplaceVehicle(s)));
    }

     public void parkVehicleInQueue(Vehicle vehicle) {
        log.info("parking vehicle in queue, "+vehicle);
        getVehiclesInQueue().add(vehicle);
    }


    public void parkVehicleInAvailableSlot(Vehicle vehicle) {
        getSlots().stream()
                .filter(ChargingSlot::isAvailable).findFirst() // take first available slot
                .ifPresent(slot -> {
                    log.info("Parking vehicle in slot, " + vehicle);
                    slot.parkVehicle(vehicle);
                });
    }

    public void releaseAndReplaceVehicle(ChargingSlot slot) {
        log.info("releasing vehicle in slot, "+slot.getVehicle());
        slot.releaseVehicle();
        executeIfTrue(!getVehiclesInQueue().isEmpty(),
                () -> {
                    log.info("Moving vehicle from queue to charge slot");
                    slot.parkVehicle(getVehiclesInQueue().poll());
                });
    }

    private Queue<Vehicle> getVehiclesInQueue() {
        return network.getInformer().getVehiclesInQueue();
    }


    private List<ChargingSlot> getSlots() {
        return network.getInformer().getSlots();
    }

}
