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


    public void process(Constraint constraint) {
        chain.process(constraint);
    }

}
