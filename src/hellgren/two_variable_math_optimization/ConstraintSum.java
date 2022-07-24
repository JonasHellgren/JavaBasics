package hellgren.two_variable_math_optimization;

public class ConstraintSum extends Constraint {


    public ConstraintSum(double sumMax) {
        super(NOT_USED_NUMBER, NOT_USED_NUMBER, sumMax);
    }

    @Override
    boolean check() {
        DesignVariable x =mediator.getDesignVariable();
        return x.x1+x.x2<=sumMax+Double.MIN_VALUE;

    }
}
