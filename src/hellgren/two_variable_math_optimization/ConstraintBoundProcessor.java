package hellgren.two_variable_math_optimization;

import java_design_patterns.I_chain_of_responsibility.NumberWrapper;

public class ConstraintBoundProcessor  extends ConstraintProcessorAbstract {
    public ConstraintBoundProcessor(ConstraintProcessorAbstract nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void process(Constraint constraint)
    {
        if (constraint instanceof ConstraintBound)
        {
            System.out.println("ConstraintBoundProcessor");
            constraint.check();
        }
        else
        {
            super.process(constraint);
        }
    }

}
