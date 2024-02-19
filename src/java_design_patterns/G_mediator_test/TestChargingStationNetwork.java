package java_design_patterns.G_mediator_test;


import common.Conditionals;
import java_design_patterns.G_mediator.charging_station_network.mediator_collegues.VehicleCharger;
import java_design_patterns.G_mediator.charging_station_network.other.Informer;
import java_design_patterns.G_mediator.charging_station_network.other.Vehicle;
import java_design_patterns.G_mediator.charging_station_network.station.ChargingStation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static common.RandomUtils.doubleInInterval;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestChargingStationNetwork {

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
        getCharger().chargeVehicles();
        assertEquals(DELTA_SOC_DEPOT_MAX,informer.getSocs().get(0),0.01);
    }


    @Test
    public void whenChargingFive_thenCorrect() {
        int nAdded = 5;
        addMultipleVehicles(nAdded);
        getCharger().chargeVehicles();
        System.out.println("station = " + station);
        assertTrue(informer.getSocs().get(0)<DELTA_SOC_DEPOT_MAX);
    }

    @Test
    public void whenChargingOneMuchThenRelease_thenCorrect() {
        station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC("A"));
        IntStream.range(0,10).forEach(i -> getCharger().chargeVehicles());
        station.getInformer().getMover().releaseChargedVehiclesAndAddFromQueue();
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
            maybeAddArrivedVehicles(probAddVehicle);
            station.updateVehiclesInStation();
            nofOccupSlots.add(informer.nOccupiedSlots());
            nofVehInQueue.add(informer.nofVehiclesInQueue());
        }

        System.out.println("nofOccupSlots = " + nofOccupSlots);
        System.out.println("nofVehInQueue = " + nofVehInQueue);

        assertTrue(nofOccupSlots.containsAll(List.of(0,5)));
        assertTrue(nofVehInQueue.containsAll(List.of(0,1)));

    }

    private void maybeAddArrivedVehicles(double probAddVehicle) {
        Conditionals.executeIfTrue(doubleInInterval(0,1)< probAddVehicle,
                () -> station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC(UUID.randomUUID().toString())));
    }

    private VehicleCharger getCharger() {
        return station.getInformer().getCharger();
    }

    private void addMultipleVehicles(int nAdded) {
        IntStream.range(0, nAdded).
                forEach(i -> station.addArrivedVehicle(Vehicle.createVehicleWithZeroSoC(Integer.toString(i))));
    }

}
