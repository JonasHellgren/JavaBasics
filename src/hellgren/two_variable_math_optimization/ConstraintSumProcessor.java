package hellgren.two_variable_math_optimization;

import org.junit.Assert;

import java.util.Objects;

public class ConstraintSumProcessor extends ConstraintProcessorAbstract {
    public ConstraintSumProcessor(ConstraintProcessorAbstract nextProcessor) {
        super(nextProcessor);
    }

    public void process(Constraint constraint)
    {
        if (constraint instanceof ConstraintSum)
        {
            boolean result=constraint.check();
            mediator.addConstraintCheckResults(result);
        }
        else
        {
            super.process(constraint);
        }
    }

}
