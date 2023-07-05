package pluralsight_new_in_java17.adv_java17.records;

public record PersonRecordWithLastName(String firstName, String lastName) implements PersonLastNameInterface {
    @Override
    public String getFullName() {
        return firstName+" "+lastName;
    }
}
