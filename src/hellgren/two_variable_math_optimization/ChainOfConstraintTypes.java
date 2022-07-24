package hellgren.two_variable_math_optimization;

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

    void setMediatorInChain(OptimizationMediatorInterface mediator) {
        ConstraintProcessorAbstract processor=chain;
           while (processor!=null) {
            processor.setMediator(mediator);
            processor=processor.getNextProcessor();
        }

    }

    protected void process(ConstraintAbstract constraint) {
        chain.process(constraint);
    }





}
