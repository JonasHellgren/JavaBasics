package java_design_patterns.I_chain_of_responsibility;

import hellgren.two_variable_math_optimization.DesignVariable;

public class Chain {

    ProcessorAbstract chain;


    public Chain(){
        buildChain();
    }

    private void buildChain(){
        chain = new NegativeProcessor(
                new ZeroProcessor(
                new PositiveProcessor(null)));
    }

    public void process(NumberWrapper request) {
        chain.process(request);
    }

}


