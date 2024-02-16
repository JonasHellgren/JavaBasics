package java_design_patterns.G_mediator.charging_station.mediator;

import common.Conditionals;
import java_design_patterns.G_mediator.charging_station.mediator_parts.ChargingSlot;
import java_design_patterns.G_mediator.charging_station.mediator_parts.PowerSplitter;
import java_design_patterns.G_mediator.charging_station.other.Vehicle;

import java.util.*;
import java.util.stream.IntStream;

import static common.Conditionals.executeIfTrue;
import static common.Conditionals.executeOneOfTwo;

public class ChargingStationMediator implements ChargingStationMediatorI {

    List<ChargingSlot> slots;
    Queue<Vehicle> vehiclesInQueu;
    PowerSplitter powerSplitter;

    public ChargingStationMediator(int nofSlots, double deltaSoCDepotMax) {
        this.slots=new ArrayList<>();
        IntStream.rangeClosed(0,nofSlots).forEach(i -> slots.add(new ChargingSlot(this)));
        this.vehiclesInQueu=new LinkedList<>();
        this.powerSplitter=new PowerSplitter(this, deltaSoCDepotMax);
    }

    @Override
    public void addArrivedVehicle(Vehicle vehicle) {
        executeOneOfTwo(isAllSlotsOccupied(),
                () -> vehiclesInQueu.add(vehicle),
                () -> parkVehicleInAvailableSlot(vehicle));
    }

    @Override
    public void chargeVehicles() {
        double deltaSoc = powerSplitter.deltaSocPerSlot();
        for (ChargingSlot slot : slots) {
            executeIfTrue(slot.isOccupied(), () -> slot.chargeVehicle(deltaSoc));
        }
    }

    @Override
    public void releaseChargedVehicleAndAddFromQueu() {
        for (ChargingSlot slot : slots) {
            if (slot.isOccupied()) {
                executeIfTrue(slot.isFullyCharged(), () -> releaseAndReplaceVehicle(slot));
            }
        }

    }

    private boolean isAllSlotsOccupied() {
        return powerSplitter.getnOccupSlots() >= slots.size();
    }

    private void parkVehicleInAvailableSlot(Vehicle vehicle) {
        for (ChargingSlot slot : slots) {
            if (slot.isAvailable()) {
                slot.parkVehicle(vehicle);
                break;
            }
        }
    }

    private void releaseAndReplaceVehicle(ChargingSlot slot) {
        slot.releaseVehicle();
        executeIfTrue(!vehiclesInQueu.isEmpty(),
                () -> slot.parkVehicle(vehiclesInQueu.poll()));
    }
}
