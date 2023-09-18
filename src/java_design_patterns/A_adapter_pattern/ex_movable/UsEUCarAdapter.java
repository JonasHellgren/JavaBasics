package java_design_patterns.A_adapter_pattern.ex_movable;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsEUCarAdapter implements EuCarAdapterInterface {
    public static final double MPH_TO_KMH = 1.60934, INC_TO_METER=0.0254;
    private CarUsInterface carUs;

    @Override
    public double getTopSpeedInKph() {
        return convertMPHtoKMPH(carUs.getTopSpeedInMph());
    }

    @Override
    public double getLengthInMeter() {
          return convertInchToMeter(carUs.getLengthInInch());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * MPH_TO_KMH;
    }

    private double convertInchToMeter(double inch) {
        return inch * INC_TO_METER;
    }

}
