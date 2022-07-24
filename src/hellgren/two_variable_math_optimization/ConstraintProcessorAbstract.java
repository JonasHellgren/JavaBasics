package hellgren.two_variable_math_optimization;

import java_design_patterns.I_chain_of_responsibility.NumberWrapper;
import lombok.ToString;

@ToString
public abstract class ConstraintProcessorAbstract extends MediatorMemberAbstract  {

    private final ConstraintProcessorAbstract nextProcessor;

    public ConstraintProcessorAbstract(ConstraintProcessorAbstract nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void process(Constraint constraint) {
        if (nextProcessor != null)
            nextProcessor.process(constraint);
    }

    public ConstraintProcessorAbstract getNextProcessor() {
        return nextProcessor;
    }
}
