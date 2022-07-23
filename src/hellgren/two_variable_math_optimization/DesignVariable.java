package hellgren.two_variable_math_optimization;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class DesignVariable  {
    double x1;
    double x2;

    public void copy(DesignVariable other) {
        this.x1 = other.x1;
        this.x2 = other.x2;
    }
}
