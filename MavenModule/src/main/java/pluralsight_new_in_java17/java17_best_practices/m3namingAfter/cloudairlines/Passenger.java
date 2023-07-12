package pluralsight_new_in_java17.java17_best_practices.m3namingAfter.cloudairlines;

public class Passenger {  //changed from Client

    String name;
    String surname;
    int bagCount;
    boolean isAdult;  //NOTE

    public boolean hasBags() {
        return bagCount > 0;
    }

}
