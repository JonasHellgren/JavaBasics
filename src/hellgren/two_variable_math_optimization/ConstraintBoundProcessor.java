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
            constraint.check();
        }
        else
        {
            super.process(constraint);
        }
    }

}
