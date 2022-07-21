package java_design_patterns.J_factory.car;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CarAbstract {
    private CarType model;

    public CarAbstract(CarType model) {
        this.model = model;
        arrangeParts();
    }

    private void arrangeParts() {
        // Do one time processing here, common for all cars
    }

    // Do subclass level processing in this method
    protected abstract void construct();

}
