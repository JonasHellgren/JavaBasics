package java_design_patterns.G_mediator.charging_station_network.station;

import java_design_patterns.G_mediator.charging_station_network.helper.VehicleCharger;
import java_design_patterns.G_mediator.charging_station_network.helper.VehicleMover;
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
    VehicleMover mover;
    VehicleCharger charger;
    Informer informer;

    public ChargingStation(int nofSlots, double deltaSoCDepotMax) {

        this.network=new Network(this);
        this.slots = new ArrayList<>();
        IntStream.range(0, nofSlots).forEach(i -> slots.add(new ChargingSlot(network)));
        this.vehiclesInQueue = new LinkedList<>();
        this.powerSplitter = new PowerSplitter(network);
        this.mover=new VehicleMover(network);
        this.charger=new VehicleCharger(network);
        this.informer=new Informer(slots, vehiclesInQueue,powerSplitter,mover,charger,deltaSoCDepotMax);

    }

    public Informer getInformer() {
        return informer;
    }

    public void addArrivedVehicle(Vehicle vehicle) {
        executeOneOfTwo(informer.isAllSlotsOccupied(),
                () -> mover.parkVehicleInQueue(vehicle),
                () -> mover.parkVehicleInAvailableSlot(vehicle));
    }

    public void updateVehiclesInStation() {
        charger.chargeVehicles();
        mover.releaseChargedVehiclesAndAddFromQueue();
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
