package java_design_patterns.I_chain_of_responsibility_test;

import java_design_patterns.I_chain_of_responsibility.Chain;
import java_design_patterns.I_chain_of_responsibility.NumberWrapper;
import org.junit.Test;

public class TestChain {

    @Test public void test()  {
        Chain chain = new Chain();
        chain.process(new NumberWrapper(90));
        chain.process(new NumberWrapper(-50));
        chain.process(new NumberWrapper(0));
        chain.process(new NumberWrapper(91));

    }


}
