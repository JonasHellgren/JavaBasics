package javax_measure;

import javax.measure.Quantity;
import javax.measure.quantity.Volume;

public class WaterTank {

    private Quantity<Volume> capacityMeasure;

    public void setCapacityMeasure(Quantity<Volume> capacityMeasure) {
        this.capacityMeasure = capacityMeasure;
    }

    public Quantity<Volume> getCapacityMeasure() {
        return capacityMeasure;
    }


}
