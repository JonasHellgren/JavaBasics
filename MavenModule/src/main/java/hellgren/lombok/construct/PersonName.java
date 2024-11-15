package hellgren.lombok.construct;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
public class PersonName {
    final String  firstName;
    final String lastName;

}
