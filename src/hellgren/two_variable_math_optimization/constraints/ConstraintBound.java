package hellgren.two_variable_math_optimization.constraints;

import hellgren.two_variable_math_optimization.cost_designvariable.DesignVariable;

public class ConstraintBound extends ConstraintAbstract {

    double x1Max;
    double x2Max;

    public ConstraintBound(double x1Max, double x2Max) {
        this.x1Max = x1Max;
        this.x2Max = x2Max;
    }

    @Override
    public boolean check(DesignVariable x) {
        return x.getX1()<=x1Max+Double.MIN_VALUE && x.getX2()<=x2Max+Double.MIN_VALUE;

    }
}
