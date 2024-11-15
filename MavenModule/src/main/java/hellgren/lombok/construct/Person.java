package hellgren.lombok.construct;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Person {
    final PersonName name;
    final String email;

    public static Person create(String firstName, String lastName) {
        var email = firstName + "." + lastName + "@gmail.com";
        return new Person(PersonName.of(firstName, lastName), email);
    }

    public static Person createFromPersonName(PersonName name) {
        var email = name.firstName + "." + name.lastName + "@gmail.com";
        return new Person(name, email);
    }



}
