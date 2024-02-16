package java_design_patterns.G_mediator.charging_station.mediator_parts;

import java_design_patterns.G_mediator.charging_station.mediator.ChargingStationMediatorI;

public class PowerSplitter {
    ChargingStationMediatorI mediator;
    final double deltaSoCDepotMax;
    int nOccupSlots;

    public PowerSplitter(ChargingStationMediatorI mediator, double deltaSoCDepotMax) {
        this.mediator = mediator;
        this.deltaSoCDepotMax = deltaSoCDepotMax;
        this.nOccupSlots=0;
    }

    public int getnOccupSlots() {
        return nOccupSlots;
    }

    public double deltaSocPerSlot() {
        return deltaSoCDepotMax /Math.max(1,nOccupSlots);
    }

    public void increaseNofOccupSlots() {
        nOccupSlots++;
    }

    public void decreaseNofOccupSlots() {
        nOccupSlots=Math.max(0,nOccupSlots-1);
    }

}
