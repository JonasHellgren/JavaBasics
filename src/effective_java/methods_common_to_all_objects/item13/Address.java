package effective_java.methods_common_to_all_objects.item13;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Address {
    String street;
    String city;

    public Address(Address address) {
        this.street= address.getStreet();
        this.city= address.getCity();

    }
}
