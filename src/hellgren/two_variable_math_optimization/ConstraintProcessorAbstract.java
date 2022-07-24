package hellgren.two_variable_math_optimization;

import lombok.ToString;

@ToString
public abstract class ConstraintProcessorAbstract extends MediatorMemberAbstract  {

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
