package pluralsight_new_in_java17.adv_java17.sealed;

/**
 * The permits clause then specifies the classes that are permitted to implement the sealed class
 */

public abstract sealed class Vehicle permits Car, Truck, TwoWheeler {

    protected final String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public abstract int getNofSeats();

}