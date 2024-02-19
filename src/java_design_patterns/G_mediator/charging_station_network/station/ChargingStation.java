package java_design_patterns.G_mediator.charging_station_network.station;

import java_design_patterns.G_mediator.charging_station_network.interface_class.NetworkI;
import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.VehicleCharger;
import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.VehicleMover;
import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.ChargingSlot;
import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.PowerSplitAlgorithm;
import java_design_patterns.G_mediator.charging_station_network.network.Network;
import java_design_patterns.G_mediator.charging_station_network.other.Informer;
import java_design_patterns.G_mediator.charging_station_network.other.Vehicle;
import lombok.extern.java.Log;

import java.util.*;
import java.util.stream.IntStream;

import static common.Conditionals.executeOneOfTwo;

@Log
public class ChargingStation  {

    NetworkI network;  //mediator
    List<ChargingSlot> slots;
    Queue<Vehicle> vehiclesInQueue;
    PowerSplitAlgorithm powerSplitter;
    VehicleMover mover;
    VehicleCharger charger;
    Informer informer;

    public ChargingStation(int nofSlots, double deltaSoCDepotMax) {

        this.network=new Network(this);
        this.slots = new ArrayList<>();
        IntStream.range(0, nofSlots).forEach(i -> slots.add(new ChargingSlot()));
        this.vehiclesInQueue = new LinkedList<>();
        this.powerSplitter = new PowerSplitAlgorithm(network);
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
        sb.append("nofVehiclesInQueue = ").append(vehiclesInQueue);
        for (ChargingSlot slot:slots) {
            sb.append(slot.toString()).append(System.lineSeparator());
        }
       return sb.toString();
    }

}
