package hellgren.two_variable_math_optimization;

public class ConstraintSum extends ConstraintAbstract {

    double sumMax;

    public ConstraintSum(double sumMax) {
        this.sumMax = sumMax;
    }

    @Override
    boolean check(DesignVariable x)  {
        return x.x1+x.x2<=sumMax+Double.MIN_VALUE;
    }
}
