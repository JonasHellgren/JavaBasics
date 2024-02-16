package java_design_patterns.G_mediator.charging_station.mediator;

import java_design_patterns.G_mediator.charging_station.mediator_parts.ChargingSlot;
import java_design_patterns.G_mediator.charging_station.mediator_parts.PowerSplitter;
import java_design_patterns.G_mediator.charging_station.other.Informer;
import java_design_patterns.G_mediator.charging_station.other.Vehicle;
import lombok.Getter;
import lombok.extern.java.Log;

import java.util.*;
import java.util.stream.IntStream;

import static common.Conditionals.executeIfTrue;
import static common.Conditionals.executeOneOfTwo;

@Getter
@Log
public class ChargingStation implements ChargingStationMediatorI {

    List<ChargingSlot> slots;
    Queue<Vehicle> vehiclesInQueu;
    PowerSplitter powerSplitter;
    Informer informer;

    public ChargingStation(int nofSlots, double deltaSoCDepotMax) {
        this.slots = new ArrayList<>();
        IntStream.range(0, nofSlots).forEach(i -> slots.add(new ChargingSlot(this)));
        this.vehiclesInQueu = new LinkedList<>();
        this.powerSplitter = new PowerSplitter(this);
        this.informer=new Informer(slots,vehiclesInQueu,deltaSoCDepotMax);
    }

    @Override
    public void addArrivedVehicle(Vehicle vehicle) {
        executeOneOfTwo(informer.isAllSlotsOccupied(),
                () -> parkVehicleInQueu(vehicle),
                () -> parkVehicleInAvailableSlot(vehicle));
    }

    @Override
    public double deltaSocPerSlot() {
        return powerSplitter.deltaSocPerSlot();
    }

    @Override
    public void chargeVehicles() {
        for (ChargingSlot slot : slots) {
            executeIfTrue(slot.isOccupied(), () -> slot.chargeVehicle());
        }
    }

    @Override
    public void releaseChargedVehiclesAndAddFromQueu() {
        for (ChargingSlot slot : slots) {
            if (slot.isOccupied()) {
                executeIfTrue(slot.isFullyCharged(), () -> releaseAndReplaceVehicle(slot));
            }
        }
    }

    private void parkVehicleInQueu(Vehicle vehicle) {
        log.info("parking vehicle in queue, "+vehicle);
        vehiclesInQueu.add(vehicle);
    }

    private void parkVehicleInAvailableSlot(Vehicle vehicle) {
        for (ChargingSlot slot : slots) {
            if (slot.isAvailable()) {
                log.info("parking vehicle in slot, "+vehicle);
                slot.parkVehicle(vehicle);
                break;
            }
        }
    }

    private void releaseAndReplaceVehicle(ChargingSlot slot) {
        log.info("releasing vehicle in slot, "+slot.getOccupVehicle());
        slot.releaseVehicle();
        executeIfTrue(!vehiclesInQueu.isEmpty(),
                () -> {
                    log.info("pulling vehicle from queue");
                    slot.parkVehicle(vehiclesInQueu.poll());
                });
    }
}
