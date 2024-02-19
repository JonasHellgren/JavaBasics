package java_design_patterns.G_mediator.charging_station_network.mediator_collegues;

import java_design_patterns.G_mediator.charging_station_network.other.Vehicle;
import lombok.extern.java.Log;

import static common.Conditionals.executeOneOfTwo;

@Log
public class ChargingSlot {
    public static final double SOC_MAX = 100;
    Vehicle vehicle;

    public ChargingSlot() {
        this.vehicle =Vehicle.createEmpty();
    }

    public boolean isAvailable() {
        return vehicle.isEmpty();
    }

    public boolean isOccupied() {
        return !isAvailable();
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void chargeVehicle(double deltaSoc) {
        executeOneOfTwo(isOccupied(),
                () -> vehicle.charge(deltaSoc),
                () -> log.info("No vehicle to charge"));
    }

    public void releaseVehicle() {
        this.vehicle = Vehicle.createEmpty();
    }

    public boolean isFullyCharged() {
        return isOccupied() && vehicle.getSoc() >= SOC_MAX;
    }

    @Override
    public String toString() {
        return "available = "+isAvailable()+", vehicle = "+ vehicle;
    }

}
