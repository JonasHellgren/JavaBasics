package hellgren.two_variable_math_optimization.cost_designvariable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class DesignVariable  {
    double x1;
    double x2;

    public void copy(DesignVariable other) {
        this.x1 = other.x1;
        this.x2 = other.x2;
    }
}
