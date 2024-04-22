package apache_collection_utils.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Customer {
    private Integer id;
    private String name;
    private Address address;

    // standard getters and setters
}
