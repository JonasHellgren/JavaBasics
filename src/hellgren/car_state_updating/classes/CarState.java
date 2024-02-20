package hellgren.car_state_updating.classes;


import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CarState {

    static final int VELOCITY = 0;
    double velocity;

    final CarStateUpdater updater;

    public CarState(CarParameters parameters, SimulationSettings settings) {
        this.velocity= VELOCITY;
        this.updater=new CarStateUpdater(parameters,settings);
    }

    public void applyForce(double force) {
        this.velocity=updater.newVelocity(this,force);
    }
}
