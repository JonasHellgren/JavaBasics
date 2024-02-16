package java_design_patterns.G_mediator_test;

import common.Conditionals;
import java_design_patterns.G_mediator.charging_station.mediator.ChargingStation;
import java_design_patterns.G_mediator.charging_station.other.Informer;
import java_design_patterns.G_mediator.charging_station.other.Vehicle;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static common.RandomUtils.doubleInInterval;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestChargingStation {

    public static final int NOF_SLOTS = 5;
    public static final int DELTA_SOC_DEPOT_MAX = 50;
    ChargingStation station;
    Informer informer;

    @Before
    public void init() {
        station = new ChargingStation(NOF_SLOTS, DELTA_SOC_DEPOT_MAX);
        informer=station.getInformer();
    }

    @Test
    public void whenCreated_thenCorrect() {
        assertEquals(NOF_SLOTS, informer.nofSlots());
        assertEquals(0, informer.nofVehiclesInQueue());
        assertEquals(0, informer.nOccupiedSlots());
    }

    @Test
    public void whenAddOneArrived_thenCorrect() {
        station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC("A"));
        assertEquals(0, informer.nofVehiclesInQueue());
        assertEquals(1, informer.nOccupiedSlots());
    }

    @Test
    public void whenAdd10Arrived_thenCorrect() {
        int nAdded = 10;
        addMultipleVehicles(nAdded);
        assertEquals(nAdded-NOF_SLOTS, informer.nofVehiclesInQueue());
        assertEquals(NOF_SLOTS, informer.nOccupiedSlots());
    }


    @Test
    public void whenChargingOne_thenCorrect() {
        station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC("A"));
        station.chargeVehicles();
        assertEquals(DELTA_SOC_DEPOT_MAX,informer.getSocs().get(0),0.01);
    }

    @Test
    public void whenChargingFive_thenCorrect() {
        int nAdded = 5;
        addMultipleVehicles(nAdded);
        station.chargeVehicles();
        assertTrue(informer.getSocs().get(0)<DELTA_SOC_DEPOT_MAX);
    }

    @Test
    public void whenChargingOneMuchThenRelease_thenCorrect() {
        station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC("A"));
        IntStream.range(0,10).forEach(i -> station.chargeVehicles());
        station.releaseChargedVehiclesAndAddFromQueu();
        assertEquals(0,informer.nOccupiedSlots());
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
            nofOccupSlots.add(informer.nOccupiedSlots());
            nofVehInQueue.add(informer.nofVehiclesInQueue());
        }

        System.out.println("nofOccupSlots = " + nofOccupSlots);
        System.out.println("nofVehInQueue = " + nofVehInQueue);

        assertTrue(nofOccupSlots.containsAll(List.of(0,5)));
        assertTrue(nofVehInQueue.containsAll(List.of(0,1)));

    }



    private void addMultipleVehicles(int nAdded) {
        IntStream.range(0, nAdded).
                forEach(i -> station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC(Integer.toString(i))));
    }


}
