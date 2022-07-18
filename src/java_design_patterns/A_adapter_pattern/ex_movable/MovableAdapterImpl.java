package java_design_patterns.A_adapter_pattern.ex_movable;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MovableAdapterImpl implements MovableAdapter {
    public static final double MPH_TO_KMH = 1.60934;
    private Movable movable;

    @Override
    public double getTopSpeed() {
        return convertMPHtoKMPH(movable.getTopSpeedInMph());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * MPH_TO_KMH;
    }
}
