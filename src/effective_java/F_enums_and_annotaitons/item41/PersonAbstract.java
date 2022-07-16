package effective_java.F_enums_and_annotaitons.item41;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class PersonAbstract {

    String name;

    @Override
    public String toString() {
        return interpret(this);
    }

    public static String interpret(PersonAbstract p) {
        if (p instanceof OnlyUpperCase) {
            return p.getName().toUpperCase();
        } else
            return p.getName();
    }

}
