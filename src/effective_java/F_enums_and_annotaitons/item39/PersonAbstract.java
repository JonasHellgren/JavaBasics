package effective_java.F_enums_and_annotaitons.item39;

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
        if (p.getClass().isAnnotationPresent(OnlyUpperCase.class)) {
            return p.getName().toUpperCase();
        } else
            return p.getName();
    }

}
