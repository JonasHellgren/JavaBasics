package hellgren.two_variable_math_optimization;

import lombok.ToString;


public class ConstraintBound extends Constraint {

    public ConstraintBound(double x1Max, double x2Max) {
        super(x1Max, x2Max,NOT_USED_NUMBER);
    }

    @Override
    void check() {
        DesignVariable x=mediator.getDesignVariable();
        //System.out.println("ConstraintBound: x1="+x.x1+", x2="+x.x2+", x1Max="+x1Max+", x2Max="+x2Max);
        boolean result = x.x1<=x1Max+Double.MIN_VALUE && x.x2<=x2Max+Double.MIN_VALUE;
        mediator.addConstraintCheckResults(result);
    }
}
