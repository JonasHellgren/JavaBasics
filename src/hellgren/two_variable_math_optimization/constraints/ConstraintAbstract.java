package hellgren.two_variable_math_optimization.constraints;

import hellgren.two_variable_math_optimization.cost_designvariable.DesignVariable;
import lombok.ToString;

@ToString
public abstract class ConstraintAbstract  {
    public abstract boolean  check(DesignVariable x);
}
