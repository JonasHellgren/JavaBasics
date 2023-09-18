package java_design_patterns.A_adapter_pattern.ex_movable;

public class FordMustang implements CarUsInterface {

    @Override
    public double getTopSpeedInMph() {
        return 268;  //MPH
    }

    @Override
    public double getLengthInInch() {
        return 188.9;
    }
}