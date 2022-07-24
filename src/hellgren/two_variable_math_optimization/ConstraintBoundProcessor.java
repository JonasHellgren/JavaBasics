package hellgren.two_variable_math_optimization;

public class ConstraintBoundProcessor  extends ConstraintProcessorAbstract {
    public ConstraintBoundProcessor(ConstraintProcessorAbstract nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void process(ConstraintAbstract constraint)
    {
        if (constraint instanceof ConstraintBound)
        {
            super.evaluate(constraint);
        }
        else
        {
            super.process(constraint);
        }
    }

}
