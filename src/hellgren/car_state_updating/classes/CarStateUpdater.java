package hellgren.car_state_updating.classes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CarStateUpdater {
    public static final double EPS = 1e-10;
    final CarParameters parameters;
    final SimulationSettings settings;

    public double acceleration(final CarState state, double force)  {
        return Math.abs(state.velocity)< EPS
        ? force/parameters.mass()
        : (force-parameters.rollRes()-parameters.airRes()*Math.pow(state.velocity,2))/parameters.mass();
    }

    public double newVelocity(final CarState state, double force) {
        return state.velocity+acceleration(state, force)* settings.deltaTime();
    }

}
