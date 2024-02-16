package java_design_patterns.G_mediator.charging_station.mediator;

import java_design_patterns.G_mediator.charging_station.mediator_collegues.ChargingSlot;
import java_design_patterns.G_mediator.charging_station.mediator_collegues.PowerSplitter;
import java_design_patterns.G_mediator.charging_station.other.Informer;
import java_design_patterns.G_mediator.charging_station.other.Vehicle;
import lombok.extern.java.Log;

import java.util.*;
import java.util.stream.IntStream;

import static common.Conditionals.executeIfTrue;
import static common.Conditionals.executeOneOfTwo;

@Log
public class ChargingStation implements ChargingStationMediatorI {

    List<ChargingSlot> slots;
    Queue<Vehicle> vehiclesInQueue;
    PowerSplitter powerSplitter;
    Informer informer;

    public ChargingStation(int nofSlots, double deltaSoCDepotMax) {
        this.slots = new ArrayList<>();
        IntStream.range(0, nofSlots).forEach(i -> slots.add(new ChargingSlot(this)));
        this.vehiclesInQueue = new LinkedList<>();
        this.powerSplitter = new PowerSplitter(this);
        this.informer=new Informer(slots, vehiclesInQueue,deltaSoCDepotMax);
    }

    @Override
    public void addArrivedVehicle(Vehicle vehicle) {
        executeOneOfTwo(informer.isAllSlotsOccupied(),
                () -> parkVehicleInQueue(vehicle),
                () -> parkVehicleInAvailableSlot(vehicle));
    }

    @Override
    public double calcDeltaSocPerSlot() {
        return powerSplitter.deltaSocPerSlot();
    }

    @Override
    public void chargeVehicles() {
        slots.forEach(s -> executeIfTrue(s.isOccupied(), () -> s.chargeVehicle()));
    }

    @Override
    public void releaseChargedVehiclesAndAddFromQueu() {
        slots.forEach(s -> executeIfTrue(s.isFullyCharged(), () -> releaseAndReplaceVehicle(s)));
       }

    @Override
    public Informer getInformer() {
        return informer;
    }

    private void parkVehicleInQueue(Vehicle vehicle) {
        log.info("parking vehicle in queue, "+vehicle);
        vehiclesInQueue.add(vehicle);
    }

    private void parkVehicleInAvailableSlot(Vehicle vehicle) {
        slots.stream()
                .filter(ChargingSlot::isAvailable).findFirst() // take first available slot
                .ifPresent(slot -> {
                    log.info("Parking vehicle in slot, " + vehicle);
                    slot.parkVehicle(vehicle);
                });
    }

    private void releaseAndReplaceVehicle(ChargingSlot slot) {
        log.info("releasing vehicle in slot, "+slot.getOccupVehicle());
        slot.releaseVehicle();
        executeIfTrue(!vehiclesInQueue.isEmpty(),
                () -> {
                    log.info("pulling vehicle from queue");
                    slot.parkVehicle(vehiclesInQueue.poll());
                });
    }
}
