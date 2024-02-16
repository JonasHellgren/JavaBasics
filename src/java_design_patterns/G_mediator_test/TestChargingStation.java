package java_design_patterns.G_mediator_test;

import common.Conditionals;
import java_design_patterns.G_mediator.charging_station.mediator.ChargingStation;
import java_design_patterns.G_mediator.charging_station.mediator_parts.ChargingSlot;
import java_design_patterns.G_mediator.charging_station.mediator_parts.PowerSplitter;
import java_design_patterns.G_mediator.charging_station.other.Vehicle;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import java.util.stream.IntStream;

import static common.RandomUtils.doubleInInterval;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestChargingStation {

    public static final int NOF_SLOTS = 5;
    public static final int DELTA_SOC_DEPOT_MAX = 50;
    ChargingStation station;
    List<ChargingSlot> slots;
    Queue<Vehicle> queue;
    PowerSplitter powerSplitter;

    @Before
    public void init() {
        station = new ChargingStation(NOF_SLOTS, DELTA_SOC_DEPOT_MAX);
        slots = station.getSlots();
        queue = station.getVehiclesInQueu();
        powerSplitter=station.getPowerSplitter();
    }

    @Test
    public void whenCreated_thenCorrect() {
        assertEquals(NOF_SLOTS, slots.size());
        assertEquals(0, queue.size());
        assertEquals(0, powerSplitter.getnOccupSlots());
    }

    @Test
    public void whenAddOneArrived_thenCorrect() {
        station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC("A"));
        assertEquals(0, queue.size());
        assertEquals(1, powerSplitter.getnOccupSlots());
    }

    @Test
    public void whenAdd10Arrived_thenCorrect() {
        int nAdded = 10;
        addMultipleVehicles(nAdded);
        assertEquals(nAdded-NOF_SLOTS, queue.size());
        assertEquals(NOF_SLOTS, powerSplitter.getnOccupSlots());
    }


    @Test
    public void whenChargingOne_thenCorrect() {
        station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC("A"));
        station.chargeVehicles();
        var socs = getSocs();
        assertEquals(DELTA_SOC_DEPOT_MAX,socs.get(0),0.01);
    }

    @Test
    public void whenChargingFive_thenCorrect() {
        int nAdded = 5;
        addMultipleVehicles(nAdded);
        station.chargeVehicles();
        var socs = getSocs();
        assertTrue(socs.get(0)<DELTA_SOC_DEPOT_MAX);
    }

    @Test
    public void whenChargingOneMuchThenRelease_thenCorrect() {
        station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC("A"));
        IntStream.range(0,10).forEach(i -> station.chargeVehicles());
        station.releaseChargedVehiclesAndAddFromQueu();
        assertEquals(0,powerSplitter.getnOccupSlots());
    }


    @Test
    public void whenSimulating_thenCorrect() {
        List<Integer> nofOccupSlots=new ArrayList<>();
        List<Integer> nofVehInQueue=new ArrayList<>();
        addMultipleVehicles(5);
        double probAddVehicle = 0.35;
        int nSimSteps = 100;
        for (int i = 0; i < nSimSteps; i++) {
            Conditionals.executeIfTrue(doubleInInterval(0,1)< probAddVehicle,
                    () -> station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC(UUID.randomUUID().toString())));
            station.chargeVehicles();
            station.releaseChargedVehiclesAndAddFromQueu();
            nofOccupSlots.add(powerSplitter.getnOccupSlots());
            nofVehInQueue.add(queue.size());
        }

        System.out.println("nofOccupSlots = " + nofOccupSlots);
        System.out.println("nofVehInQueue = " + nofVehInQueue);

        assertTrue(nofOccupSlots.containsAll(List.of(0,5)));
        assertTrue(nofVehInQueue.containsAll(List.of(0,1)));

    }


    private List<Double> getSocs() {
        List<Double> socs=new ArrayList<>();
        for (ChargingSlot slot : slots) {
            if (slot.isOccupied()) {
                Vehicle occupVehicle = slot.getOccupVehicle();
                socs.add(occupVehicle.getSoc());
            }
        }
        return socs;
    }


    private void addMultipleVehicles(int nAdded) {
        IntStream.range(0, nAdded).
                forEach(i -> station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC(Integer.toString(i))));
    }


}
