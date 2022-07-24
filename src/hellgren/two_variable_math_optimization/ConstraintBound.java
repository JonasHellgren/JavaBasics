package hellgren.two_variable_math_optimization;

import lombok.ToString;


public class ConstraintBound extends Constraint {

    public ConstraintBound(double x1Max, double x2Max) {
        super(x1Max, x2Max,NOT_USED_NUMBER);
    }

    @Override
    boolean check() {
        DesignVariable x=mediator.getDesignVariable();
        return x.x1<=x1Max+Double.MIN_VALUE && x.x2<=x2Max+Double.MIN_VALUE;

    }
}
