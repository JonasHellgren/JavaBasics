package hellgren.two_variable_math_optimization;

public class ConstraintBoundProcessor  extends ConstraintProcessorAbstract {
    public ConstraintBoundProcessor(ConstraintProcessorAbstract nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void process(Constraint constraint)
    {
        if (constraint instanceof ConstraintBound)
        {
            boolean result=constraint.check();
            mediator.addConstraintCheckResults(result);
           //  System.out.println("ConstraintBoundProcessor mediator.getDesignVariable() = " + mediator.getDesignVariable());
        }
        else
        {
            super.process(constraint);
        }
    }

}
