package hellgren.two_variable_math_optimization.constraint_processor;

import hellgren.two_variable_math_optimization.constraints.ConstraintAbstract;
import hellgren.two_variable_math_optimization.constraints.ConstraintSum;

public class ConstraintSumProcessor extends ConstraintProcessorAbstract {
    public ConstraintSumProcessor(ConstraintProcessorAbstract nextProcessor) {
        super(nextProcessor);
    }

    public void process(ConstraintAbstract constraint)
    {
        if (constraint instanceof ConstraintSum)
        {
            super.evaluate(constraint);
        }
        else
        {
            super.process(constraint);
        }
    }



}
