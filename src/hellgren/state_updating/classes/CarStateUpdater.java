package hellgren.state_updating.classes;

import lombok.AllArgsConstructor;
import tec.units.ri.internal.MathUtil;

@AllArgsConstructor
public class CarStateUpdater {
    public static final double EPS = 1e-10;
    final CarParameters parameters;
    final SimulationSettings settings;

    public double acceleration(double speed, double force)  {
        return Math.abs(speed)< EPS
        ? force/parameters.mass()
        : (force-parameters.rollRes()-parameters.airRes()*Math.pow(speed,2))/parameters.mass();
    }

    public double newVelocity(CarState state, double force) {
        return state.velocity+acceleration(state.velocity, force)* settings.deltaTime();
    }

}
