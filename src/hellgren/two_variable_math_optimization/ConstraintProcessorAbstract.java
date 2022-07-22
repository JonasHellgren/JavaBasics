package hellgren.two_variable_math_optimization;

import java_design_patterns.I_chain_of_responsibility.NumberWrapper;

public class ConstraintProcessorAbstract {

    private final ConstraintProcessorAbstract nextProcessor;

    public ConstraintProcessorAbstract(ConstraintProcessorAbstract nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void process(Constraint constraint) {
        if (nextProcessor != null)
            nextProcessor.process(constraint);
    }

}
