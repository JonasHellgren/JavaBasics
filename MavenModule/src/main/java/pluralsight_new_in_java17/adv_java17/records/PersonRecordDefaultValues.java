package pluralsight_new_in_java17.adv_java17.records;

import lombok.Builder;

import static pluralsight_new_in_java17.adv_java17.records.DefaultPredicates.*;

public record PersonRecordDefaultValues(String name, String address, Integer age) {

    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_ADDRESS = "Not known";
    public static final Integer DEFAULT_AGE=0;

    @Builder
    public PersonRecordDefaultValues(String name, String address, Integer age) {
        this.name=defaultIfNullString.apply(name,DEFAULT_NAME);
        this.address=defaultIfNullString.apply(address,DEFAULT_ADDRESS);
        this.age=defaultIfNullInteger.apply(age,DEFAULT_AGE);
    }
}
