package pluralsight_new_in_java17.adv_java17.records;

import lombok.NonNull;

public record PersonRecordSpecificConstructors(String name, String address) {
    public static final String NOT_KNOWN_ADDRESS ="Not known";

    /*
    public PersonRecordSpecificConstructors {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }
*/
    public PersonRecordSpecificConstructors(@NonNull  String name, @NonNull String address) {
        this.name=name;
        this.address=address;
    }

    public static PersonRecordSpecificConstructors newFromName(String name) {
       return new  PersonRecordSpecificConstructors(name, NOT_KNOWN_ADDRESS);
    }

}
