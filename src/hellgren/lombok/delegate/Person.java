package hellgren.lombok.delegate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Delegate;

/**
 *  @Delegate gives skipping un-necessary wrapper code
 */

@AllArgsConstructor
@Getter
public class Person {
    @Delegate
    private final PersonHelper helper = new PersonHelper();

    private String name;
    private int age;
}
