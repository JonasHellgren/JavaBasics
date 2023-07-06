package pluralsight_new_in_java17.adv_java17.sealed;

public final class MotorCycle extends TwoWheeler implements Service {

    public MotorCycle(String registrationNumber) {
        super(registrationNumber);
    }

    public int getNofSeats() {
        return super.nofSeats;
    }
}