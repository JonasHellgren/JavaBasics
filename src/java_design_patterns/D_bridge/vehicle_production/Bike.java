package java_design_patterns.D_bridge.vehicle_production;

public class Bike extends Vehicle {

    @Override
    public void manufacture() {
        System.out.println("Manufactoring Bike...");
        super.processInWorkShops();
        System.out.println("Done.");
        System.out.println();
    }



    @Override
    public int minWorkTime() {
        return 5;
    }

}
