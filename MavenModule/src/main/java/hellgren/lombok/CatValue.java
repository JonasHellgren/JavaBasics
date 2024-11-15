package hellgren.lombok;

import lombok.Setter;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.PackagePrivate;

//@Value(staticConstructor = "of")   CatValue.of("Kisse",0.2d,1);  //
@Value  //similar to the @Data annotation, but it creates immutable objects.
@Setter
public class CatValue {
    String name;
    double weight;
    @NonFinal
    @PackagePrivate
    int age;
}