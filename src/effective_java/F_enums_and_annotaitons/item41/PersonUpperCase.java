package effective_java.F_enums_and_annotaitons.item41;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Locale;


public class PersonUpperCase extends PersonAbstract implements OnlyUpperCase{

    public PersonUpperCase(String name) {
        super(name);
    }
}
