package pluralsight_new_in_java17.adv_java17.records;

import lombok.Builder;
import lombok.ToString;

@Builder
public record PersonLombok(long id, String name, String email, boolean status) {

    public PersonLombok copyWithNewEmail(String email) {
        return PersonLombok.builder()
                .id(id()).name(name()).email(email).status(status()).build();
    }

}