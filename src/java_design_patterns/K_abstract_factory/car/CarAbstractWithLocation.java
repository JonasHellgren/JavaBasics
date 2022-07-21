package java_design_patterns.K_abstract_factory.car;

import java_design_patterns.J_factory.car.CarType;

public abstract class CarAbstractWithLocation {

    public CarAbstractWithLocation(CarType model, Location location){
        this.model = model;
        this.location = location;
    }

    protected abstract void construct(CarType model, Location location);

    private CarType model = null;
    private Location location = null;

    //getters and setters

    @Override
    public String toString() {
        return "Model- "+model + " built in "+location;
    }
}
