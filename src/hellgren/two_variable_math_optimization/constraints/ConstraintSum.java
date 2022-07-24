package hellgren.two_variable_math_optimization.constraints;

import hellgren.two_variable_math_optimization.cost_designvariable.DesignVariable;

public class ConstraintSum extends ConstraintAbstract {

    double sumMax;

    public ConstraintSum(double sumMax) {
        this.sumMax = sumMax;
    }

    @Override
    public boolean check(DesignVariable x)  {
        return x.getX1()+x.getX2()<=sumMax+Double.MIN_VALUE;
    }
}
