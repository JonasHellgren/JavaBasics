package java_design_patterns.G_mediator.charging_station.mediator_collegues;

import java_design_patterns.G_mediator.charging_station.mediator.ChargingStationMediatorI;
import java_design_patterns.G_mediator.charging_station.other.Vehicle;
import lombok.extern.java.Log;

import static common.Conditionals.executeOneOfTwo;

@Log
public class ChargingSlot {
    ChargingStationMediatorI mediator;
    boolean available;
    Vehicle occupVehicle;

    public ChargingSlot(ChargingStationMediatorI mediator) {
        this.available = true;
        this.mediator = mediator;
    }

    public boolean isAvailable() {
        return available && occupVehicle == null;
    }

    public boolean isOccupied() {
        return !isAvailable();
    }

    public void parkVehicle(Vehicle vehicle) {
        this.available = false;
        this.occupVehicle = vehicle;
    }

    public Vehicle getOccupVehicle() {
        return occupVehicle;
    }

    public void chargeVehicle() {
        executeOneOfTwo(isOccupied(),
                () -> occupVehicle.charge(mediator.calcDeltaSocPerSlot()),
                () -> log.info("No vehicle to charge"));
    }

    public void releaseVehicle() {
        this.available = true;
        this.occupVehicle = null;
    }

    public boolean isFullyCharged() {
        return isOccupied() && occupVehicle.getSoc() >= 100;

    }

    @Override
    public String toString() {
        return "available = "+available+", vehicle = "+occupVehicle;
    }

}
