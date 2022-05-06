package hellgren.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.NonFinal;
import lombok.experimental.PackagePrivate;

@Data  //Getter, Setter, EqualsAndHashCode, ToString, RequiredArgsConstructor
@AllArgsConstructor
public class CatData {
    private String name;
    private double weight;
    private int age;
}
