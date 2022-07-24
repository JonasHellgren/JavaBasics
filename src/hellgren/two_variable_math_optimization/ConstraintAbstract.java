package hellgren.two_variable_math_optimization;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
public abstract class ConstraintAbstract  {

    abstract boolean  check(DesignVariable x);

}
