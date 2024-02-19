package java_design_patterns.G_mediator.charging_station_network.station;

import java_design_patterns.G_mediator.charging_station_network.interface_class.ChargingStationMediatorI;
import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.ChargingSlot;
import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.PowerSplitter;
import java_design_patterns.G_mediator.charging_station_network.network.Network;
import java_design_patterns.G_mediator.charging_station_network.other.Informer;
import java_design_patterns.G_mediator.charging_station_network.other.Vehicle;
import lombok.extern.java.Log;

import java.util.*;
import java.util.stream.IntStream;

import static common.Conditionals.executeIfTrue;
import static common.Conditionals.executeOneOfTwo;

@Log
public class ChargingStation  {

    Network network;
    List<ChargingSlot> slots;
    Queue<Vehicle> vehiclesInQueue;
    PowerSplitter powerSplitter;
    Informer informer;

    public ChargingStation(int nofSlots, double deltaSoCDepotMax) {

        this.network=new Network(this);
        this.slots = new ArrayList<>();
        IntStream.range(0, nofSlots).forEach(i -> slots.add(new ChargingSlot(network)));
        this.vehiclesInQueue = new LinkedList<>();
        this.powerSplitter = new PowerSplitter(network);
        this.informer=new Informer(slots, vehiclesInQueue,powerSplitter,deltaSoCDepotMax);

    }

    public Informer getInformer() {
        return informer;
    }

    public void addArrivedVehicle(Vehicle vehicle) {
        executeOneOfTwo(informer.isAllSlotsOccupied(),
                () -> parkVehicleInQueue(vehicle),
                () -> parkVehicleInAvailableSlot(vehicle));
    }

    public void updateCharge() {

    }

    public void chargeVehicles() {
        slots.forEach(s -> executeIfTrue(s.isOccupied(), () -> s.chargeVehicle()));
    }

    public void releaseChargedVehiclesAndAddFromQueue() {
        slots.forEach(s -> executeIfTrue(s.isFullyCharged(), () -> releaseAndReplaceVehicle(s)));
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
                    log.info("Moving vehicle from queue to charge slot");
                    slot.parkVehicle(vehiclesInQueue.poll());
                });
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (ChargingSlot slot:slots) {
            sb.append(slot.toString()).append(System.lineSeparator());
        }
       return sb.toString();
    }

}
