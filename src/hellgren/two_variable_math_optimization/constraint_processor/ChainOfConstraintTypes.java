package hellgren.two_variable_math_optimization.constraint_processor;

import hellgren.two_variable_math_optimization.constraints.ConstraintAbstract;
import hellgren.two_variable_math_optimization.mediator_facade.OptimizationMediatorInterface;

public class ChainOfConstraintTypes {

    ConstraintProcessorAbstract chain;

    public ChainOfConstraintTypes(){
        super();
        buildChain();

    }

    private void buildChain(){
        chain = new ConstraintBoundProcessor(
                new ConstraintSumProcessor(null));
    }

    public void setMediatorInChain(OptimizationMediatorInterface mediator) {
        ConstraintProcessorAbstract processor=chain;
           while (processor!=null) {
            processor.setMediator(mediator);
            processor=processor.getNextProcessor();
        }

    }

    public void process(ConstraintAbstract constraint) {
        chain.process(constraint);
    }





}
