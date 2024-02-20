package hellgren.car_state_updating.classes;

import lombok.Getter;

@Getter
public class Car {

    final CarState state;

    public Car(CarParameters parameters,SimulationSettings settings) {
        this.state=new CarState(parameters,settings);
    }

    public void applyForce(double force) {
        state.applyForce(force);
    }



}
