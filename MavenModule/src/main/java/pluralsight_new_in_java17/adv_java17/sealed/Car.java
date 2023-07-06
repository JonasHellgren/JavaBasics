package pluralsight_new_in_java17.adv_java17.sealed;

import lombok.Getter;

@Getter
public final class Car extends Vehicle implements Service{

    int nofSeats;

    public Car(String registrationNumber, int nofSeats) {
        super(registrationNumber);
        this.nofSeats=nofSeats;
    }
    @Override
    public int getMaxServiceIntervalInMonths() {
        return 12;
    }


}
