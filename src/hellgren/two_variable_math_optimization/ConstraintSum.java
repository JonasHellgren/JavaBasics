package hellgren.two_variable_math_optimization;

public class ConstraintSum extends Constraint {


    public ConstraintSum(double sumMax) {
        super(NOT_USED_NUMBER, NOT_USED_NUMBER, sumMax);
    }

    @Override
    void check() {
        DesignVariable x =mediator.getDesignVariable();
        //System.out.println("ConstraintSum: x1="+x.x1+", x2="+x.x2+", x1Max="+x1Max+", x2Max="+x2Max);
        boolean result = x.x1+x.x2<=sumMax+Double.MIN_VALUE;
        mediator.addConstraintCheckResults(result);

    }
}
