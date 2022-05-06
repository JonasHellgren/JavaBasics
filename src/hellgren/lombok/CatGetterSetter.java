package hellgren.lombok;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString(includeFieldNames = false)
public class CatGetterSetter {
    private final String name;
    @Getter(AccessLevel.NONE)  //disable default getter/setter generation on a specific field
    @NonNull
    private double weight;
    @Setter(AccessLevel.NONE)  //disable default getter/setter generation on a specific field
    @ToString.Exclude
    @NonNull
    private int age;
}