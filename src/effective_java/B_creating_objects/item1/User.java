package effective_java.B_creating_objects.item1;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class User {

    public static final String REGULAR = "Regular";
    public static final String EMPTY = "";
    private final String name;
    private final String address;
    private final String type;

    public User(String name, String address, String type) {

        this.name = name;
        this.address = address;
        this.type = type;
    }

    public static User createUserDefaultType(String name, String address) {
        return new User(name, address, REGULAR);
    }

    public static User createUserEmptyAddress(String name, String type) {
        return new User(name, EMPTY, type);
    }
}
