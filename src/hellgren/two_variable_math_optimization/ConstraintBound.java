package hellgren.two_variable_math_optimization;

public class ConstraintBound extends ConstraintAbstract {

    double x1Max;
    double x2Max;

    public ConstraintBound(double x1Max, double x2Max) {
        this.x1Max = x1Max;
        this.x2Max = x2Max;
    }

    @Override
    boolean check(DesignVariable x) {
        return x.x1<=x1Max+Double.MIN_VALUE && x.x2<=x2Max+Double.MIN_VALUE;

    }
}
