package hellgren.rule_engine.elevator_control;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestElevatorRules {

    ElevatorRules rules;

    @Before
    public void init () {
        rules=new ElevatorRules();
    }

    @Test
    public void  givenRules_whenSpeedUpPos2_then1 () {
        Integer out=rules.process(1,2);
        assertEquals(1,out.intValue());
    }

    @Test
    public void  givenRules_whenSpeedUpPos10_then0 () {
        Integer out=rules.process(1,10);
        assertEquals(0,out.intValue());
    }


    @Test
    public void  givenRules_whenSpeedStillUpPos10_then1orMin1 () {
        Integer out=rules.process(0,10);
        System.out.println("out = " + out);
        assertTrue(out==-1 || out==1);
    }

    @Test
    public void  givenRules_whenSpeedDownPos2_thenMin1 () {
        Integer out=rules.process(-1,2);
        assertEquals(-1,out.intValue());
    }


    @Test
    public void  givenRules_whenSpeedDownPos10_then0 () {
        Integer out=rules.process(-1,10);
        assertEquals(0,out.intValue());
    }

    @Test
    public void  givenRules_whenSpeedDownPos0_then0 () {
        Integer out=rules.process(-1,0);
        assertEquals(0,out.intValue());
    }


    @Test
    public void  givenRules_whenSpeedStillPos0_then1 () {
        Integer out=rules.process(0,0);
        assertEquals(1,out.intValue());
    }


    @Test
    public void  givenRules_whenSpeedUpPos30_then1 () {
        Integer out=rules.process(1,30);
        assertEquals(0,out.intValue());
    }


    @Test
    public void  givenRules_whenSpeedStillPos30_thenMin1 () {
        Integer out=rules.process(0,30);
        assertEquals(-1,out.intValue());
    }

}
