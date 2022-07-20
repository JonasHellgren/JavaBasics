package java_design_patterns.D_bridge.vehicle_production;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    // assempbly line for the workshops
    protected List<WorkShop> workshops = new ArrayList<WorkShop>();

    public Vehicle() {
        super();
    }

    public boolean joinWorkshop(WorkShop workshop) {
        return workshops.add(workshop);
    }

    public abstract void manufacture();

    public abstract int minWorkTime();

    void processInWorkShops() {
        workshops.stream().forEach(workshop -> workshop.work(this));
    }

}
