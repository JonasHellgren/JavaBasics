package hellgren.two_variable_math_optimization;

public class ConstraintSumProcessor extends ConstraintProcessorAbstract {
    public ConstraintSumProcessor(ConstraintProcessorAbstract nextProcessor) {
        super(nextProcessor);
    }

    public void process(Constraint constraint)
    {
        if (constraint instanceof ConstraintSum)
        {
            System.out.println("ConstraintSumProcessor");
        }
        else
        {
            super.process(constraint);
        }
    }

}
