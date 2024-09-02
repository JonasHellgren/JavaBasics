package hellgren.lombok;

import lombok.Builder;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder
@ToString(includeFieldNames = false)
public class BuilderCat {
    public static final int DEFAULT_AGE = 1;
    public String name;
    public double weight;
    @Builder.Default
    public int age = DEFAULT_AGE;

    @Singular   //build single or multiple child items
    public List<String> childs;


    public BuilderCat() {
    }

}

