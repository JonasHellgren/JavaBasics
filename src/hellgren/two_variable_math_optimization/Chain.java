package hellgren.two_variable_math_optimization;

public class Chain  {

    ConstraintProcessorAbstract chain;

    public Chain(){
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
