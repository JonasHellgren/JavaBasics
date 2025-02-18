package hellgren.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  //Getter, Setter, EqualsAndHashCode, ToString, RequiredArgsConstructor
@AllArgsConstructor
public class CatData {
    private String name;
    private double weight;
    private int age;
}
