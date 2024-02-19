package hellgren.state_updating.classes;


import lombok.ToString;

@ToString
public class CarState {

    public static final int VELOCITY = 0;
    public double velocity;

    final CarStateUpdater updater;

    public CarState(CarParameters parameters, SimulationSettings settings) {
        this.velocity= VELOCITY;
        this.updater=new CarStateUpdater(parameters,settings);
    }

    public void applyForce(double force) {
        this.velocity=updater.newVelocity(this,force);
    }



}
