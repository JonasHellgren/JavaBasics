package pluralsight_new_in_java17.adv_java17.sealed;

import lombok.Getter;

@Getter
public non-sealed class TwoWheeler extends Vehicle implements Service {

    int nofSeats;

    public TwoWheeler(String registrationNumber) {
        super(registrationNumber);
        this.nofSeats=1;
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 24;
    }

    @Override
    public int getMaxDistanceBetweenServicesInKilometers() {
        return 1000;
    }
}
