package hellgren.rule_engine.math_step;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRuleStep {

    private static final double DELTA = 0.001;
    RuleStep rules;

    @Before
    public void init () {
        rules=new RuleStep();
    }

    @Test
    public void  givenRules_whenNegNum_then0 () {
        double out=rules.process(-10d);
        assertEquals(0,out, DELTA);
    }



    @Test
    public void  givenRules_when0d5_then0d5 () {
        double out=rules.process(0.5d);
        assertEquals(0.5,out, DELTA);
    }


    @Test
    public void  givenRules_when10_then1 () {
        double out=rules.process(10d);
        assertEquals(1,out, DELTA);
    }


}
