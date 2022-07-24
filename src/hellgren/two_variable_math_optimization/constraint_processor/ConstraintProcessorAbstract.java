package hellgren.two_variable_math_optimization.constraint_processor;

import hellgren.two_variable_math_optimization.constraints.ConstraintAbstract;
import hellgren.two_variable_math_optimization.cost_designvariable.DesignVariable;
import hellgren.two_variable_math_optimization.mediator.MediatorMemberAbstract;
import lombok.ToString;

@ToString
public abstract class ConstraintProcessorAbstract extends MediatorMemberAbstract {

    private final ConstraintProcessorAbstract nextProcessor;

    public ConstraintProcessorAbstract(ConstraintProcessorAbstract nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void process(ConstraintAbstract constraint) {
        if (nextProcessor != null)
            nextProcessor.process(constraint);
    }

    protected void evaluate(ConstraintAbstract constraint) {
        DesignVariable x =mediator.getDesignVariable();
        boolean result = constraint.check(x);
        mediator.addConstraintCheckResults(result);
    }

    public ConstraintProcessorAbstract getNextProcessor() {
        return nextProcessor;
    }
}
