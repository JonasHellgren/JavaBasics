package pluralsight_new_in_java17.adv_java17.sealed;

public sealed interface Service permits Car, MotorCycle, Truck, TwoWheeler {

    int getMaxServiceIntervalInMonths();

    default int getMaxDistanceBetweenServicesInKilometers() {
        return 100000;
    }

}
