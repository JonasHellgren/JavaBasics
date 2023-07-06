package pluralsight_new_in_java17.adv_java17.sealed;

import lombok.Getter;

@Getter
public final class Truck extends Vehicle implements Service {

    int loadingCapacity;

    public Truck(String registrationNumber, int nofSeats) {
        super(registrationNumber);
        this.loadingCapacity = nofSeats;
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 24;
    }

    @Override
    public int getNofSeats() {
        return 2;
    }
}
